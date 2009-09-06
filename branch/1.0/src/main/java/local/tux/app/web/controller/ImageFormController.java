package local.tux.app.web.controller;

import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import local.tux.Constants;
import local.tux.app.model.Image;
import local.tux.app.web.common.controller.LookUpTableController;

public class ImageFormController extends LookUpTableController {

	public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, 
			Object command, BindException errors) throws Exception {
	
		Image image = (Image) command;
	
		// validate a file was entered
		if (image.getFile().length == 0) {
		Object[] args = new Object[] { getText("uploadForm.file", request.getLocale()) };
		errors.rejectValue("file", "errors.required", args, "File");
		return showForm(request, response, errors);
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");
		InputStream stream = file.getInputStream();
		FileOutputStream out = new FileOutputStream(Constants.IMAGE_PATH);
		
		stream.close();
		return showNewForm(request, response);
	}

}
