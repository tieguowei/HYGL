package com.resale.util;

import java.util.Random;
import java.util.UUID;

/**
 * 
 *
 * Description:
 *
 * @author ouyangjin
 * @version 1.0
 * <pre>
 * Modification History: 
 * Date         Author      Version     Description 
 * ------------------------------------------------------------------ 
 * 2013-7-5      ouyangjin       1.0         1.0 Version 
 * </pre>
 */
public class UUIDUtil {
	
	/**
	 * 获得32位去 - 字符
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/***
	 * 生成uid 8位数字
	 */
	public static String generateUID(){
	    Random random = new Random();
	    String result="";
	    for(int i=0;i<8;i++){
	        result += (random.nextInt(9)+1);
	    }
	    return result;
	}
	
}
