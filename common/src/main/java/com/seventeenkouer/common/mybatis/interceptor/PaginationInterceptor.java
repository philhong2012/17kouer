package com.seventeenkouer.common.mybatis.interceptor;


import com.seventeenkouer.common.utils.StringUtils;
import com.seventeenkouer.common.mybatis.page.*;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.PropertyException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


//只拦截select部分
@Intercepts({@Signature(type=Executor.class,method="query",args={ MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class })})
public class PaginationInterceptor implements Interceptor {

	private static Logger logger = LoggerFactory.getLogger(PaginationInterceptor.class);
	private static String dialectConf = "";	//数据库方言
	private static Dialect dialect = new MySql5Dialect();	//数据库方言
	private static String pageSqlId = ""; //mapper.xml中需要拦截的ID(正则匹配)
	 
	public Object intercept(Invocation invocation) throws Throwable {
		
		MappedStatement mappedStatement=(MappedStatement)invocation.getArgs()[0];
		if(mappedStatement.getId().matches(pageSqlId)){ //拦截需要分页的SQL
			Object parameter = invocation.getArgs()[1]; 
			BoundSql boundSql = mappedStatement.getBoundSql(parameter);
			String originalSql = boundSql.getSql().trim();   
			RowBounds rowBounds = (RowBounds)invocation.getArgs()[2];
	
			Object parameterObject = boundSql.getParameterObject();
			if(boundSql==null || boundSql.getSql()==null || "".equals(boundSql.getSql()))
				return null;
			//分页参数--上下文传参
			Page page = null;
			PageContext context=PageContext.getContext();
			
			//map传参每次都将currentPage重置,先判读map再判断context
			if(parameterObject!=null)
				page = (Page) ReflectHelper.isPage(parameterObject, "page");
			
			//分页参数--context参数里的Page传参
			if(page==null && context.isPagination()==true)
			{
				page = context;
			}
			
			//后面用到了context的东东
			if(page!=null) 			
			{
			  int totpage=0;	
			  //得到总记录数
			  
			  	StringBuffer countSql  = new StringBuffer(originalSql.length()+100 );
				countSql.append("select count(1) from (").append(originalSql).append(") t");
					 Connection connection=mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection()  ;          
	           PreparedStatement countStmt = connection.prepareStatement(countSql.toString());  
	           BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(),countSql.toString(),boundSql.getParameterMappings(),parameterObject);
//				Field metaParamsField = ReflectHelper.getFieldByFieldName(boundSql, "metaParameters");
//				if (metaParamsField != null) {
//					MetaObject mo = (MetaObject) ReflectHelper.getValueByFieldName(boundSql, "metaParameters");
//					ReflectHelper.setValueByFieldName(countBS, "metaParameters", mo);
//				}
				setParameters(countStmt,mappedStatement,countBS,parameterObject);
				if(page.isGetTotalPage()){
					ResultSet rs = countStmt.executeQuery();
					if (rs.next()) {
						totpage = rs.getInt(1);
					}
					rs.close();
				}

	           countStmt.close();  
	           connection.close();
			  
			    //分页计算
		        page.init(totpage,page.getPageSize(),page.getCurrentPage());
			  
				if(rowBounds == null || rowBounds == RowBounds.DEFAULT){
					rowBounds= new RowBounds(page.getPageSize()*(page.getCurrentPage()-1),page.getPageSize());
					
				}
				
				if(dialectConf!=null&&"oracle".equals(dialectConf.toLowerCase())){
					//如果是oracle，则调用oracle分页查询
					dialect = new OracleDialect();
				}
	
				//分页查询 本地化对象 修改数据库注意修改实现
			    String pagesql=dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit());
			    invocation.getArgs()[2] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);   
			    BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), pagesql,boundSql.getParameterMappings(),boundSql.getParameterObject());   
			    MappedStatement newMs = copyFromMappedStatement(mappedStatement,new BoundSqlSqlSource(newBoundSql));

			    invocation.getArgs()[0]= newMs;
			}
		}
		return invocation.proceed();
	}
	
	public static class BoundSqlSqlSource implements SqlSource {
        BoundSql boundSql;  
        public BoundSqlSqlSource(BoundSql boundSql) {  
            this.boundSql = boundSql;  
        }  
  
        public BoundSql getBoundSql(Object parameterObject) {  
            return boundSql;  
        }  
    }  
	
	public Object plugin(Object arg0) {
		 return Plugin.wrap(arg0, this);
	}
	public void setProperties(Properties p) {
		dialectConf = p.getProperty("dialectConf");
		if (StringUtils.isEmpty(dialectConf)) {
			try {
				throw new PropertyException("dialect property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
		pageSqlId = p.getProperty("pageSqlId");
		if (StringUtils.isEmpty(pageSqlId)) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
	}
    
    /** 
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.DefaultParameterHandler 
     * @param ps 
     * @param mappedStatement 
     * @param boundSql 
     * @param parameterObject 
     * @throws SQLException 
     */  
    private void setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,Object parameterObject) throws SQLException {  
        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (parameterMappings != null) {  
            Configuration configuration = mappedStatement.getConfiguration();
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null ? null: configuration.newMetaObject(parameterObject);
            for (int i = 0; i < parameterMappings.size(); i++) {  
                ParameterMapping parameterMapping = parameterMappings.get(i);  
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    Object value;  
                    String propertyName = parameterMapping.getProperty();  
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    if (parameterObject == null) {  
                        value = null;  
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {  
                        value = parameterObject;  
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {  
                        value = boundSql.getAdditionalParameter(propertyName);  
                    } else if (propertyName.startsWith(StringUtils.ITEM_PREFIX)&& boundSql.hasAdditionalParameter(prop.getName())) {
                        value = boundSql.getAdditionalParameter(prop.getName());  
                        if (value != null) {  
                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));  
                        }  
                    } else {  
                        value = metaObject == null ? null : metaObject.getValue(propertyName);  
                    }  
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if (typeHandler == null) {  
                        throw new ExecutorException("There was no TypeHandler found for parameter "+ propertyName + " of statement "+ mappedStatement.getId());
                    }
                    if(null!=value){
                    	typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());  
                    }
                }  
            }  
        }  
    }  
    
    private MappedStatement copyFromMappedStatement(MappedStatement ms,   
    		 SqlSource newSqlSource) {   
    		MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(),
    		ms.getId(), newSqlSource, ms.getSqlCommandType());   
    		builder.resource(ms.getResource());   
    		builder.fetchSize(ms.getFetchSize());   
    		builder.statementType(ms.getStatementType());   
    		builder.keyGenerator(ms.getKeyGenerator());   
    		//builder.keyProperty(ms.getKeyProperty());   
    		builder.timeout(ms.getTimeout());   
    		 builder.parameterMap(ms.getParameterMap());   
    		builder.resultMaps(ms.getResultMaps());   
    		builder.cache(ms.getCache());   
    		MappedStatement newMs = builder.build();   
    		return newMs;   
    		}   
    	 

}