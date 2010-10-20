package local.tux.app.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.tux.Constants;
import local.tux.app.model.Image;
import local.tux.app.service.LookUpNameGenericManager;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FileController implements Controller {

	/**
	 * this class needs to pass two parameters.
	 * one is the type of request. (so far we only have image only
	 * one is the id the that type.
	 */
	
	private LookUpNameGenericManager<Image, Long> imageManager;
	private String imageStoragePath = "" ;
	public void setImageManager(LookUpNameGenericManager<Image, Long> imageManager){
		this.imageManager = imageManager;
	}
	
	public void setImageStoragePath(String imageStoragePath){
		this.imageStoragePath  = imageStoragePath;
	}
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		OutputStream out = response.getOutputStream();
		String id = request.getParameter("id");
		if (StringUtils.isBlank(id)== false){
			Image image = imageManager.get(new Long(id));
			if (Constants.IMAGE_TYPE.equals(request.getParameter("type"))){
				pipe(image.getPath(), out);
				out.flush();
				out.close();
			}else if (Constants.THUMB_TYPE.equals(request.getParameter("type"))){
				pipe(image.getThumbPath(), out);
				out.flush();
				out.close();
			}
		}else if (StringUtils.isBlank(request.getParameter("path")) == false){
			String absolutePath = imageStoragePath + request.getParameter("path");
			pipe(absolutePath, out);
			out.flush();
			out.close();
		}
		return null;
		
	}
	
	public void pipe (String in, OutputStream out) throws IOException{
		byte[] buffer = new byte[1024];
		int bytesRead = 0;
		FileInputStream fin = new FileInputStream(in);
		BufferedInputStream bin = new BufferedInputStream(fin);
		 while ((bytesRead = bin.read(buffer)) != -1) {
             out.write(buffer);
         }
		 bin.close();
	}
	

}
