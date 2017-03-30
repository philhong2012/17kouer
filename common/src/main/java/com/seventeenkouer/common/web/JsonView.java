package com.seventeenkouer.common.web;


import com.seventeenkouer.common.Exception.SeventeenkouException;
import com.seventeenkouer.common.utils.StringUtils;
import com.seventeenkouer.common.constants.BaseCode;
import com.seventeenkouer.common.dto.BaseDto;
import com.seventeenkouer.common.mapper.JsonMapper;

import com.seventeenkouer.common.utils.SystemProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


/**
 * 将Object转为json输出
 * 修改人：kylin.woo
 * 修改时间：2014-05-14
 * @author pzh
 * @version maps1.0
 */
public class JsonView {
	
	public static final String CODE = "code";
    public static final String DATA = "data";
    public static final String ERROR_MESSAGE = "message";
	public static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";
    public static Logger logger = LoggerFactory.getLogger(JsonView.class);


	/**
	 * 将Object转为json输出
	 * @param result
	 * @param response
	 * @return
	 */
	public static ModelAndView renderJson(Object result, HttpServletResponse response){
        try {
			logger.debug("responseData:{}",result);
			String JsonStr = JsonMapper.alWaysMapper().toJson(result).toString();
			response.setContentType(APPLICATION_JSON_UTF8);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(JsonStr);
        } catch (Exception e) {
        	logger.error("renderObject to Json error:"+e.getMessage(),e);
        } 
        return null;  
    }


	/**
	 * 将text转为json输出
	 * @param text
	 * @param response
	 * @return
	 */
	public static ModelAndView renderText(String text, HttpServletResponse response){
		try {
			logger.debug("responseData:{}",text);
			response.setContentType(APPLICATION_JSON_UTF8);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(text);
		} catch (Exception e) {
			logger.error("renderText  error:"+e.getMessage(),e);
		}
		return null;
	}



	/**
	 * 将data转为json输出
	 * @param data
	 * @param response HttpServletResponse
	 * @return ModelAndView 返回类型为spring的ModelAndView or {@code null}
	 */
	public static ModelAndView dataToJson(Object data, HttpServletResponse response){
        try {
        	ResponseParam resParam=new ResponseParam();
        	resParam.setCode(BaseCode.SUCCESS_CODE);
        	resParam.setData(data);
        	resParam.setMessage("");
			//判断data对象是否为baseDto类且rtnMsg是否有值，是的话将值赋给message
			if(data instanceof BaseDto && !StringUtils.isEmpty(((BaseDto) data).getRtnMsg())){
				resParam.setMessage(((BaseDto) data).getRtnMsg());
			}
        	return dataToJson(resParam, response);
        } catch (Exception e) {
        	logger.error("Object to Json error:"+e.getMessage(),e);
        } 
        return null;  
    }

	/**
	 * 将data转为json输出(主要解决项目归档，项目撤销返回值为true，message无法返回，手机端旧版本无法兼容问题 add by luyi 2016/10/28)
	 * @param message
	 * @param response HttpServletResponse
	 * @return ModelAndView 返回类型为spring的ModelAndView or {@code null}
	 */
	public static ModelAndView strToJson(String message, HttpServletResponse response){
		try {
			ResponseParam resParam=new ResponseParam();
			resParam.setCode(BaseCode.SUCCESS_CODE);
			resParam.setData(true);
			resParam.setMessage(message);
			return dataToJson(resParam, response);
		} catch (Exception e) {
			logger.error("Object to Json error:"+e.getMessage(),e);
		}
		return null;
	}

	public static ModelAndView dataToJson(String sid,Object data, HttpServletResponse response){ 
		ResponseParam result=new ResponseParam();
		//result.setHash(hash);
		result.setSid(sid);
		result.setData(data);
		return dataToJson(result, response);
	}
	
	public static ModelAndView dataToJson(Object data,long timestamp, HttpServletResponse response){ 
		ResponseParam result=new ResponseParam();
		result.setData(data);
		result.setTimestamp(timestamp);
		return dataToJson(result, response);
	}
	
	public static ModelAndView dataToJson(String hash,Object data,String code,String message, HttpServletResponse response){ 
		ResponseParam result=new ResponseParam();
		result.setHash(hash);
		result.setData(data);
		result.setCode(code);
		result.setMessage(message);
		return dataToJson(result, response);
	}
	

	/**
	 * 将error转为json输出
	 * @param errorCode
	 * @param response HttpServletResponse
	 * @return ModelAndView 返回类型为spring的ModelAndView or {@code null}
	 */
	public static ModelAndView addErrorToJson(String errorCode,String errorMsg, HttpServletResponse response){  
        try {
            ResponseParam resParam=new ResponseParam();
        	resParam.setCode(errorCode);
        	resParam.setData(new HashMap());
        	resParam.setMessage(errorMsg);
        	//response.setStatus(600);
        	dataToJson(resParam, response);

        } catch (Exception e) {
        	logger.error("Object to Json error:"+e.getMessage(),e);
        } 
        return null;  
    }
	
	/**
	 * 将error转为json输出
	 * @param errorCode
	 * @param response HttpServletResponse
	 * @return ModelAndView 返回类型为spring的ModelAndView or {@code null}
	 */
	public static ModelAndView addErrorToJson(String errorCode, HttpServletResponse response){  
        try {
        	ResponseParam resParam=new ResponseParam();
        	resParam.setCode(errorCode);
        	resParam.setData(new HashMap());
        	if(BaseCode.resultMsg.get(errorCode)!=null){
        		resParam.setMessage(BaseCode.resultMsg.get(errorCode).toString());
        	}else{
        		resParam.setMessage(errorCode);
        	}
        	return dataToJson(resParam, response);
        } catch (Exception e) {
        	logger.error("Object to Json error:"+e.getMessage(),e);
        } 
        return null;  
    }
	
	public static ModelAndView addErrorToJson(Exception ex, HttpServletResponse response,Object data){
        try {
			ex.printStackTrace();
            ResponseParam resParam=new ResponseParam();
            SeventeenkouException zde = BaseCode.getZdnstException(ex);
            String errorMessage = BaseCode.getMsg(zde);            
        	resParam.setCode(zde.getCode());
        	resParam.setData(data == null?new HashMap():data);        	
        	resParam.setMessage(errorMessage);
			/**
			 * 增加返回详情错误，方便前端调试，只用于开发测试环境，生产环节需要关闭掉
			 */
			if(isSystemDebug()){
				resParam.setDetailMessage(BaseCode.getDetailMsg(ex));
			}
			/***/
        	dataToJson(resParam, response);
        } catch (Exception e) {
        	logger.error("Object to Json error:"+e.getMessage(),e);
        } 
        return null;  
    }


	/**
	 *将error转为Response结果输出
	 * @param ex
	 * @param data
	 * @return
	 */
	public static ResponseResult addErrorToJson(Exception ex, Object data){
		try {
			ResponseResult resParam=new ResponseResult();
			SeventeenkouException zde = BaseCode.getZdnstException(ex);
			String errorMessage = BaseCode.getMsg(zde);
			resParam.setCode(zde.getCode());
			//resParam.setData(data == null?new HashMap():data);
			resParam.setData(data);

			resParam.setMessage(errorMessage);
			/**
			 * 增加返回详情错误，方便前端调试，只用于开发测试环境，生产环节需要关闭掉
			 */
			if(isSystemDebug()){
				resParam.setDetailMessage(BaseCode.getDetailMsg(ex));
			}
			/***/
			return resParam;
		} catch (Exception e) {
			logger.error("Object to Json error:"+e.getMessage(),e);
		}
		return null;
	}

	/**
	 * 将data转为Response结果输出
	 * @param data
	 * @return ModelAndView 返回类型为spring的ModelAndView or {@code null}
	 */
	public static ResponseResult dataToJson(Object data){
		try {
			ResponseResult resParam=new ResponseResult();
			resParam.setCode(BaseCode.SUCCESS_CODE);
			resParam.setData(data);
			resParam.setMessage("");
			return resParam;
		} catch (Exception e) {
			logger.error("Object to Json error:"+e.getMessage(),e);
		}
		return null;
	}


	/**
	 * 读取配置，系统是否调试状态
	 * @return
	 */
	private static boolean isSystemDebug(){
		try{
			String systemDebug = SystemProperties.getProperties().getProperty("system.debug");
			if(StringUtils.COMMON_VALUE_YES.equals(systemDebug)){
				return true;
			}
		}catch (Exception e){
			logger.error("读取是否系统调试配置异常:"+e.getMessage());
		}
		return false;
	}
	
	
	/**
	 * 将 ResponseParam 转为json输出(如果没给code默认为1[成功],如果没有给消息内容默认为空)
	 * @param resParam ResponseParam  
	 * @param response HttpServletResponse
	 * @return ModelAndView 返回类型为spring的ModelAndView or {@code null}
	 * @author kui.he
	 * 
	 */
	private static ModelAndView dataToJson(ResponseParam resParam, HttpServletResponse response){
        MediaType jsonMimeType = MediaType.APPLICATION_JSON;  
        try {  
        	if (StringUtils.isEmpty(resParam.getCode())) {
        		resParam.setCode(BaseCode.SUCCESS_CODE);
			}
        	
        	if (StringUtils.isEmpty(resParam.getMessage())) {
        		resParam.setMessage("");
			}
        	String message = resParam.getMessage();
        	if(StringUtils.isBlank(message) && BaseCode.resultMsg.containsKey(resParam.getCode())){
        		message = BaseCode.resultMsg.get(resParam.getCode()).toString();
        	}
//        	logger.info("responseCode:{}={}",resParam.getCode(),message);
//        	logger.debug("responseData:{}",resParam.getData());
        	
        	//自定义转化器,将null转化为空 added by pengzh 2014-12-22
        	/*ObjectMapper objMapper = new ObjectMappingCustomer();
        	jsonConverter.setObjectMapper(objMapper);*/

			String JsonStr = JsonMapper.alWaysMapper().toJson(resParam).toString();
			//我们发现通过这样的方式设置content-type有可能设置不成功，造成间歇性偶然乱码
			response.setContentType(APPLICATION_JSON_UTF8);
			response.setCharacterEncoding("UTF-8");
			//所以我们强加Content-Type 为 json 格式
			response.addHeader("Content-Type",APPLICATION_JSON_UTF8);
			response.getWriter().write(JsonStr);
			response.getWriter().flush();
            //jsonConverter.write(resParam, jsonMimeType, new ServletServerHttpResponse(response));
            
        } catch (Exception e) {
        	logger.error("Object to Json error:"+e.getMessage(),e);
        } 
        return null; 
	}

}
