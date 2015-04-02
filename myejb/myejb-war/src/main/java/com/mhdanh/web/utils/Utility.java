package com.mhdanh.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@Stateless
public class Utility {
	private static Logger logger = Logger.getLogger(Utility.class.getName());
	
	public String getFileNameFromPath(String path){
		File file = new File(path);
		return file.getName();
	}
	
	public boolean downloadFile(HttpServletResponse response,String inputFile,String filename) throws IOException{
		File file = new File(inputFile);
		if(file.exists()){
			try {
				FileInputStream inputStream= new FileInputStream(file);
				ServletOutputStream outStream = response.getOutputStream();
		        byte[] buffer = new byte[4096];
		        int bytesRead = -1;
		        response.setContentType("application/*");
				response.setHeader("Content-Disposition","attachment;filename="+filename);
				response.setContentLength((int) file.length());
		        while ((bytesRead = inputStream.read(buffer)) != -1) {
		            outStream.write(buffer, 0, bytesRead);
		        }
		        inputStream.close();
		        outStream.close();
		        return true;
			} catch (Exception e) {
				System.out.println("Download file unsuccessful: " + e);
				logger.log(Level.WARNING,"Path file input: " + inputFile);
				logger.log(Level.WARNING,"Download file unsuccessfule",e);
				return false;
			}
		}else{
			logger.log(Level.WARNING,"File download not exist");
			return false;
		}
	}
}
