package com.seventeenkouer.common.mybatis.page;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/** 
 * @author Administrator 
 *  反射工具 
 */  
public class ReflectHelper {  
    /** 
     * 获取obj对象fieldName的Field 
     * @param obj 
     * @param fieldName 
     * @return 
     */  
    public static Field getFieldByFieldName(Object obj, String fieldName) {

    		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {  
                try {  
                    return superClass.getDeclaredField(fieldName);  
                } catch (NoSuchFieldException e) {  
                }  
            }  
    		  return null;
    	} 
    
    /**
     * 检查是否含有分页或本来就是分页类
     * @param obj
     * @param fieldName
     * @return
     */
    public static Object isPage(Object obj, String fieldName) {
    	
		if (obj instanceof Map) {
			Map map = (Map)obj;
			return map.get(fieldName);

		} else {
    		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
                try {
                    return superClass.getDeclaredField(fieldName);
                } catch (NoSuchFieldException e) {
                }
            }
    		  return null;
    	}

    }



    /**
     * 获取obj对象fieldName的属性值
     * @param obj
     * @param fieldName
     * @return
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static Object getValueByFieldName(Object obj, String fieldName)
            throws SecurityException, NoSuchFieldException,
            IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        Object value = null;
        if(field!=null){
            if (field.isAccessible()) {
                value = field.get(obj);
            } else {
                field.setAccessible(true);
                value = field.get(obj);
                field.setAccessible(false);
            }
        }
        return value;
    }

    /**
     * 设置obj对象fieldName的属性值
     * @param obj
     * @param fieldName
     * @param value
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws SecurityException, NoSuchFieldException,IllegalArgumentException, IllegalAccessException {

    	if(obj instanceof Map){
			Map map = (Map)obj;
			map.put(fieldName,value);
    	}else{
            //Field field = getFieldByFieldName(obj, fieldName);
            Field field = obj.getClass().getDeclaredField(fieldName);
            if (field.isAccessible()) {
                field.set(obj, value);
            } else {
                field.setAccessible(true);
                field.set(obj, value);
                field.setAccessible(false);
            }
    	}

    }


    public static  String outObjPropertyString(Object obj){
            StringBuffer sb = new StringBuffer();
            if(null != obj){
                try {
                	 if(obj instanceof Map){
                		 sb.append(obj.toString());
                	 }else{
                		 ReflectHelper.getPropertyString(obj, sb);
                	 }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
        
        public static String getPropertyString(Object entityName, StringBuffer sb) throws Exception {
            Class c = entityName.getClass();
            Field field [] = c.getDeclaredFields();
            Object obj = null;
            String classname = "";
            Object tempObj = null;
            for(Field f : field){
                
                obj = ReflectHelper.invokeMethod(entityName,f.getName(),f.getType(),null);
                String value="";
                if(null != obj)
                {
                    if(obj.getClass().isArray())
                    {
                        for (int i=0;i<Array.getLength(obj);i++)
                        {
                            tempObj = Array.get(obj, i);
                            if(tempObj.getClass().isPrimitive())
                            {
                                //sb.append(tempObj.toString());
                                value=tempObj.toString();
                            }
                            else if(tempObj instanceof String)
                            {
                            	//sb.append(tempObj.toString());
                                value=tempObj.toString();
                            }
                            else if(tempObj instanceof Date)
                            {
                            	//sb.append(tempObj.toString());
                                value=tempObj.toString();
                            }
                            else if(tempObj instanceof Number)
                            {
                            	//sb.append(tempObj.toString());
                                value=tempObj.toString();
                            }else {
                            	sb.append(f.getName());
                                sb.append(" : ");
                            	ReflectHelper.getPropertyString(tempObj , sb);
                            }
                        }
                    }else{
                    	sb.append(" "+f.getName());
                        sb.append(" : ");
                        sb.append(obj);
                    }
                    
//                    classname = obj.getClass().getName();
//                    if(classname.indexOf("com.cignacmb.core.model.") > -1)
//                    {
//                    	ReflectHelper.getPropertyString(obj , sb);
//                    }

                }
                if(value!=null&&!"".equals(value.trim())){
                	sb.append(" "+f.getName());
                    sb.append(" : ");
                    sb.append(value);
                }
                
                /*if (f.getType() == Address.class)
                {
                    this.getPropertyString(obj , sb);
                }*/
                
                //sb.append(obj);
                //sb.append("\n");
            }
            //sb.append("------ " + " end ------\n");
            return sb.toString();
        }
        
        
        public static Object invokeMethod(Object owner, String methodName, Class fieldType, Object[] args) throws Exception{
            Class ownerClass = owner.getClass();

            methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
            Method method = null;
            try {
                if(fieldType == boolean.class)
                {
                    method = ownerClass.getMethod("is" + methodName);
                }
                else
                {
                    method = ownerClass.getMethod("get" + methodName);
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                //e.printStackTrace();
                return null;
            }

            return method.invoke(owner);
            
        }
    
    
}  
