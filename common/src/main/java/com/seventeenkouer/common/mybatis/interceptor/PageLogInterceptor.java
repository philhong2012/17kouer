package com.seventeenkouer.common.mybatis.interceptor;

import com.seventeenkouer.common.utils.StringUtils;
import com.seventeenkouer.common.mybatis.page.ReflectHelper;

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
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


//拦截所有sql部分，此拦截器只为打印sql语句
@Intercepts({  
    @Signature(type = Executor.class, method = "update", args = {  
            MappedStatement.class, Object.class }),  
    @Signature(type = Executor.class, method = "query", args = {  
            MappedStatement.class, Object.class, RowBounds.class,  
            ResultHandler.class }) }) 
public class PageLogInterceptor implements Interceptor{

	private static Logger log = Logger.getLogger(PageLogInterceptor.class);
	 
	public Object intercept(Invocation invocation) throws Throwable {
		
		MappedStatement mappedStatement=(MappedStatement)invocation.getArgs()[0];
		//log.info(mappedStatement.getId());
		
		Object parameter = invocation.getArgs()[1]; 
		BoundSql boundSql = mappedStatement.getBoundSql(parameter); 
		Object parameterObject = boundSql.getParameterObject();
		
		if(boundSql!=null && boundSql.getSql()!=null && !"".equals(boundSql.getSql())){
			if(mappedStatement.getId()!=null&&mappedStatement.getId().contains(".")){
				String sqlClassName=mappedStatement.getId().substring(0, mappedStatement.getId().lastIndexOf("."));
				log = Logger.getLogger(sqlClassName);
			}
			log.info(boundSql.getSql().trim().replaceAll("\n", " "));
			if(parameterObject!=null){
				String params= ReflectHelper.outObjPropertyString(parameterObject);
				log.info("*****params:"+params);
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

	@Override
	public void setProperties(Properties properties) {
		
	}
	
    /** 
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.DefaultParameterHandler 
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject 
     * @throws SQLException 
     */  
    private Map setParameters(MappedStatement mappedStatement,BoundSql boundSql,Object parameterObject) throws SQLException {  
    	Map map=new HashMap();
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
                    	//typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());  
                    }
                    map.put(propertyName, value);
                } 
            }  
        }
        return map;
    }  
	
	

}