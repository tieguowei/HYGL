package com.resale.background.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.resale.background.constants.Constants;


public class DataUtil {

	/**
	 * 文件上传
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	public static File dataUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
		File file2 = null;
		String path = null;
		try {
			// 得到上传的文件名 System.out.println(file.getOriginalFilename());
			if (!file.isEmpty()) {
				// 文件不为空保存到webapp下
				String realPath = request.getSession().getServletContext().getRealPath(Constants.UPLOAD);
				// 修改文件名称
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				// 给上传的文件一个新的名称
				String fileName = sdf.format(new Date()) + file.getOriginalFilename();
				// 设置存放图片文件的路径
				path = realPath + "\\" + fileName;
				// 转存文件到指定的路径
				file.transferTo(new File(path));
				file2 = new File(path);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file2;
	}

	/**
	 * 模板下载
	 * 
	 * @param realPath
	 * @param response
	 */
	public static void downLoadTemplate(String realPath, HttpServletResponse response) {
		BufferedInputStream br = null;
		OutputStream out = null;
		try {
			File f = new File(realPath);
			if (!f.exists()) {
				response.sendError(404, "File not found!");
				return;
			}
			br = new BufferedInputStream(new FileInputStream(f));
			byte[] buf = new byte[1024];
			int len = 0;
			response.reset();
			String filename = new String(f.getName().getBytes(), "ISO-8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");

			out = response.getOutputStream();
			while ((len = br.read(buf)) > 0)
				out.write(buf, 0, len);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	 public static String getWeekOfDate(Date dt) { 
	       // String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"}; 
	        String[] weekDays = {"1", "2", "3", "4", "5", "6", "7"}; 
	        Calendar cal = Calendar.getInstance(); 
	        cal.setTime(dt); 
	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; 
	        if (w < 0) 
	            w = 0; 
	        return weekDays[w]; 
	    } 
	   
	   public static int getDayFromDate(Date date){
		   Calendar c=Calendar.getInstance(); 
		   c.setTime(date); 
		   int day1=c.get(Calendar.DAY_OF_MONTH); 
		   return day1;
	   }

	 public static boolean compDay(Date d1,Date d2){
		try{
			int day1 = getDayFromDate(d1);
			int day2 = getDayFromDate(d2);
			 
			if(day1==day2){
				return true;
			}
			 
			return false;
		 } catch (NumberFormatException e) {
			return false;
		 }
	 }  
	  
	/**
	 * 比较两个时间（周几）是否相等
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean compWeek(Date d1,Date d2){
		try {
			String week1= getWeekOfDate(d1);
			String week2= getWeekOfDate(d2);
			if(week1.equals(week2)){
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * 比较两个时间 是否相等
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean compTime(Date d1,Date d2){
		try {
			SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HHmmss" );  
			String s1 =sdf.format(d1);
			String s2 = sdf.format(d2);
			
			s1=s1.substring(11, s1.length());
			s2=s2.substring(11, s2.length());
			int total1 = Integer.valueOf(s1);
			int total2 = Integer.valueOf(s2);
			return total2-total1>0?true:false;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
