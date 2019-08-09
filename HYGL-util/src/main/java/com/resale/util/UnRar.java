package com.resale.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

public class UnRar {
	public  void unrar(String srcRarPath,String dstDirectoryPath)throws Exception { 
		 if (!srcRarPath.toLowerCase().endsWith(".rar")) {
             System.out.println("非rar文件！");
              return;
         }	 
		 File dstDiretory = new File(dstDirectoryPath);
		 if (!dstDiretory.exists()) {// 目标目录不存在时，创建该文件夹
			 dstDiretory.mkdirs();
		 }
		 File fol=null,out=null;
		 Archive a = null;
		 a = new Archive(new File(srcRarPath));
		 if (a != null){
			// 打印文件信息.
			a.getMainHeader().print(); 
			FileHeader fh = a.nextFileHeader();
			while (fh != null){
			if (fh.isDirectory()) { // 文件夹
				// 如果是中文路径，调用getFileNameW()方法，否则调用getFileNameString()方法，还可以使用if(fh.isUnicode())
				if(existZH(fh.getFileNameW())){
				 fol = new File(dstDirectoryPath + File.separator+ fh.getFileNameW());
				}else{
					fol = new File(dstDirectoryPath + File.separator+ fh.getFileNameString());
				}
				fol.mkdirs();
			 } else { // 文件
				if(existZH(fh.getFileNameW())){
					out = new File(dstDirectoryPath + File.separator + fh.getFileNameW().trim());
				}else{
					out = new File(dstDirectoryPath + File.separator+ fh.getFileNameString().trim());
				}
				try {// 之所以这么写try，是因为万一这里面有了异常，不影响继续解压.
					if (!out.exists()) {
						if (!out.getParentFile().exists()){// 相对路径可能多级，可能需要创建父目录.
							out.getParentFile().mkdirs();
						}
							out.createNewFile();
					}
					FileOutputStream os = new FileOutputStream(out);
					a.extractFile(fh, os);
					System.out.println("解压的文件==="+ fh.getFileNameString());
					System.out.println("解压的文件==="+dstDirectoryPath+File.separator+fh.getFileNameString());
					os.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
				fh = a.nextFileHeader();
			}
			a.close();
		}
		System.out.println(whetherExistFile(dstDirectoryPath,"txt").contains(File.separator));
	}
    public static String whetherExistFile(String path,String endStr){
		File file = new File(path);
		File filelist[] = file.listFiles();
		int kjbCount = 0;
		String filePath="";
		for(File f : filelist){
			String filename = f.getName();
			if(filename.endsWith(endStr)){
				filePath=  path+File.separator+ filename;
				kjbCount= kjbCount+1;
			}
		}
		if(kjbCount>1){
			return "只允许有一个kjb文件";
		}
		return filePath;
    }
    public String copyKjb(File kjbFile,String dstDirectoryPath) throws IOException{
    	 File dstDiretory = new File(dstDirectoryPath);
		 if (!dstDiretory.exists()) {// 目标目录不存在时，创建该文件夹
			 dstDiretory.mkdirs();
		 }
    	 File out=null;
    	 if(existZH(kjbFile.getName())){
				out = new File(dstDirectoryPath + File.separator + kjbFile.getName().trim());
			}else{
				out = new File(dstDirectoryPath + File.separator+ kjbFile.getName().trim());
		} 
    	 if (!out.exists()) {
			if (!out.getParentFile().exists()){// 相对路径可能多级，可能需要创建父目录.
				out.getParentFile().mkdirs();
			}
			out.createNewFile();
		}
    	return dstDirectoryPath + File.separator + kjbFile.getName();
    }
	public String unrar(File rarFile,String dstDirectoryPath)throws Exception { 
		 File dstDiretory = new File(dstDirectoryPath);
		 if (!dstDiretory.exists()) {// 目标目录不存在时，创建该文件夹
			 dstDiretory.mkdirs();
		 }
		 File fol=null,out=null;
		 Archive a =  new Archive(rarFile);
		 if (a != null){
			// 打印文件信息.
			a.getMainHeader().print(); 
			FileHeader fh = a.nextFileHeader();
			while (fh != null){
			if (fh.isDirectory()) { // 文件夹
			// 如果是中文路径，调用getFileNameW()方法，否则调用getFileNameString()方法，还可以使用if(fh.isUnicode())
				if(existZH(fh.getFileNameW())){
				    fol = new File(dstDirectoryPath + File.separator+ fh.getFileNameW());
				}else{
					fol = new File(dstDirectoryPath + File.separator+ fh.getFileNameString());
				}
				fol.mkdirs();
			} else { // 文件
				if(existZH(fh.getFileNameW())){
					out = new File(dstDirectoryPath + File.separator + fh.getFileNameW().trim());
				}else{
					out = new File(dstDirectoryPath + File.separator+ fh.getFileNameString().trim());
				}
				try {// 之所以这么写try，是因为万一这里面有了异常，不影响继续解压.
					if (!out.exists()) {
						if (!out.getParentFile().exists()){// 相对路径可能多级，可能需要创建父目录.
							out.getParentFile().mkdirs();
						}
						out.createNewFile();
					}
					FileOutputStream os = new FileOutputStream(out);
					a.extractFile(fh, os);
					os.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
				fh = a.nextFileHeader();
			}
			a.close();
		}
		return  whetherExistFile(dstDirectoryPath,"kjb");
	}

	/*
	 * 判断是否是中文
	 */

 public static boolean existZH(String str){
	String regEx = "[\\u4e00-\\u9fa5]";
	Pattern p = Pattern.compile(regEx);
	Matcher m = p.matcher(str);
	while (m.find()) { 
		return true;
	}
	return false;
	}

}
