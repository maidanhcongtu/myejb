package com.mhdanh.web.ws;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.mhdanh.web.utils.Utility;

@Path("/file")
public class DownloadFileWS {

	private static Logger logger = Logger.getLogger(DownloadFileWS.class.getName());
	
	@EJB
	private Utility utility;
	
	@GET
	@Path("/download")
	public void downloadFile(@QueryParam("fileName") String fileName,@Context HttpServletResponse response) throws IOException{
		logger.log(Level.WARNING,"Download file name:" + fileName);
		//utility.downloadFile(response, fileName, "okman.jsp");
	}
}
