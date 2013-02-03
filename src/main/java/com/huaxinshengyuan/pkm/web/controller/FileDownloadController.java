package com.huaxinshengyuan.pkm.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller      
public class FileDownloadController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Value("#{prop['uploaded_file_path']}") private String filePath;
	@RequestMapping(value="/doc/{docName}/{orgName}/download", method = RequestMethod.GET)
	    public void handleFileDownload(
	    		@PathVariable("docName") String docName,
	    		@PathVariable("orgName") String orgName,
	    		HttpServletRequest request,
	    		HttpServletResponse response) {
	        File file = new File(filePath+docName); 
	        response.setContentLength(new Long(file.length()).intValue());
	        ServletContext      context  = request.getSession().getServletContext();
	        String   mimetype = context.getMimeType(docName);
	        response.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
	        log.debug("---download file: " +orgName);
	        response.setHeader( "Content-Disposition", "attachment; filename=\"" + orgName + "\"" );
	        try {
	            FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return;
	    }
	
	
}