/**
 * Copyright (C) 2013-2014 the original author or authors.
 */
package com.seventeenkouer.common.Exception;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description
 *
 * @author zhou jun
 * @version v1.0
 *
 * @2013-10-16
 *
 */
@SuppressWarnings("rawtypes")
public class ExceptionCodeFormat {

	private static Map<String, String> codeMap = new HashMap<String, String>();
	
	private static Map<String, String> layerCodeMap = new HashMap<String, String>();
	
	/**
	 * web layer exceptions
	 */
	public static final String WEB_LAYER = "1";
	
	/**
	 * application exceptions
	 */
	public static final String APP_LAYER = "2";
	
	/**
	 * model exceptions
	 */
	public static final String MOD_LAYER = "3";

	/**
	 * repository exceptions
	 */
	public static final String REP_LAYER = "4";
	
	/**
	 * No layer exceptions
	 */
	public static final String NO_LAYER = "0";
	
	
	public static String getCode(Class clazz){
		synchronized (codeMap) {
			if(codeMap.isEmpty()){
				codeMap = initCodeResource();
			}
		}
		
		String code = "0000";
		String pkgPath = getPackagePath(clazz);
		for (Iterator iterator = codeMap.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			String codeRegex = codeMap.get(key);
			if(match(codeRegex, pkgPath)){
				code = key;
			}
		}
		
		String layerCode = NO_LAYER;
		for (Iterator iterator = layerCodeMap.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			String layerCodeKey = layerCodeMap.get(key);
			if(pkgPath.lastIndexOf("." + layerCodeKey) != -1 || pkgPath.indexOf("." + layerCodeKey + ".") != -1){
				if(key.equalsIgnoreCase("WEB_LAYER")){
					layerCode = WEB_LAYER;
				} else if(key.equalsIgnoreCase("APP_LAYER")){
					layerCode = APP_LAYER;
				}else if(key.equalsIgnoreCase("MOD_LAYER")){
					layerCode = MOD_LAYER;
				}else if(key.equalsIgnoreCase("REP_LAYER")){
					layerCode = REP_LAYER;
				} else 	{
					layerCode = NO_LAYER;
				}
			}
		}
		code = code + layerCode;
		return code;
	}

	/**
	 * @return
	 */
	private static Map<String, String> initCodeResource() {
		initLayerCode();
		ResourceBundle rb = ResourceBundle.getBundle("exception_code_format");
		Set<String> codeSet = rb.keySet();
		for (Iterator iterator = codeSet.iterator(); iterator.hasNext();) {
			String code = (String) iterator.next();
			if(layerCodeMap.containsKey(code)){
				layerCodeMap.put(code, rb.getString(code));
			} else {
				codeMap.put(code, rb.getString(code));
			}
		}
		return codeMap;
	}

	/**
	 * 
	 */
	private static void initLayerCode() {
		layerCodeMap.put("web_layer", "");
		layerCodeMap.put("app_layer", "");
		layerCodeMap.put("mod_layer", "");
		layerCodeMap.put("rep_layer", "");
	}
	
	public static boolean match(String regex, String value){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if(matcher.matches()){
			return true;
		}
		return false;
	}
	
	public static String getPackagePath(Class clazz){
		Package pkg = clazz.getPackage();
		return pkg.getName();
	}
}
