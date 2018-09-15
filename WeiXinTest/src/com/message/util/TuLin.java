package com.message.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
/*
 * 图灵机器人API
 */
public class TuLin {
	/** 调用图灵机器人平台接口 
	 * @throws UnsupportedEncodingException 
	*/ 
	public static  String getTuLinAnswer(String content) throws UnsupportedEncodingException {
		//图灵机器人APIKEY
	     String APIKEY = "7089e3a0ae08451495968d378d431c36"; 
		
	     //将内容转码
	     String INFO = URLEncoder.encode(content, "utf-8"); 
	     //接口URL
	    String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + INFO; 
	     //String getURL = "http://restapi.amap.com/v3/weather/weatherInfo?city=110101&key=" + APIKEY; 
	    URL getUrl = null;
		try {
			getUrl = new URL(getURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) getUrl.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block 
			e1.printStackTrace();
		} 
	    try {
			connection.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	    // 取得输入流，并使用Reader读取 
	    BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    StringBuffer sb = new StringBuffer(); 
	    String line = ""; 
	    try {
			while ((line = reader.readLine()) != null) { 
			    sb.append(line); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    // 断开连接 
	  
	    connection.disconnect(); 
	    //返回结果,因为返回的是JSON格式，截取字符串
	   String resp = sb.toString().substring(23,sb.toString().length()-2);
	   
	    
	    return resp;
		

	}
	
	
}

