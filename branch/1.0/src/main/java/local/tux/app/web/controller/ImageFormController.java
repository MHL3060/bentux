package local.tux.app.web.controller;


import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import eu.cedarsoft.utils.image.ImageConverter;

import local.tux.Constants;
import local.tux.TuxBaseObjectConverter;
import local.tux.app.model.Image;
import local.tux.app.model.Product;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.LookUpTableController;

public class ImageFormController extends LookUpTableController {

	private LookUpNameGenericManager lookUpNameGenericManager;

	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
		if (request.getParameter("cancel") != null) {
			return new ModelAndView(getCancelView());
		}
		
		return super.processFormSubmission(request, response, command, errors);
	}
	public void setProductManager(LookUpNameGenericManager lookUpNameGenericManager){
		this.lookUpNameGenericManager = lookUpNameGenericManager;
	}

	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		/*
		TuxBaseObjectConverter projectEditor = new TuxBaseObjectConverter();
		projectEditor.setGenreicManager(lookUpNameGenericManager);
		binder.registerCustomEditor(Product.class, projectEditor);
		*/
		super.initBinder(request, binder);
	}

	public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, 
			Object command, BindException errors) throws Exception {
		String docBase = request.getSession().getServletContext().getRealPath("/");
		Image image = (Image) command;
	
		// validate a file was entered
		if (image.getFile().length == 0) {
			Object[] args = new Object[] { getText("uploadForm.file", request.getLocale()) };
			errors.rejectValue("file", "errors.required", args, "File");
			return showForm(request, response, errors);
		}
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");
		String fileName = file.getFileItem().getName();
		String[] tokens = fileName.split("\\.");
		if (tokens.length < 2){
			errors.getFieldError("file");
		}
		String type = tokens[tokens.length -1];
		
		FileOutputStream out = new FileOutputStream(docBase + File.separatorChar + Constants.IMAGE_PATH + File.separatorChar + fileName);
		ImageInputStream in = new MemoryCacheImageInputStream(file.getInputStream());
		BufferedImage originalImage = saveFile(in, type, out);
        out.close();
		
		ImageConverter imageConverter = new ImageConverter();
		BufferedImage thumbnail = imageConverter.resize(originalImage, Constants.DIMENSION);
		String path =(String) request.getSession().getAttribute("");
		out = new FileOutputStream(docBase + File.separatorChar + Constants.IMAGE_PATH + File.separatorChar + "thumbs" + File.separatorChar + fileName);
		ImageIO.write(thumbnail, type, out);
		out.close();
		
		return showNewForm(request, response);
	}
	
	private BufferedImage saveFile(ImageInputStream in, String type, OutputStream out) throws IOException {
		
		BufferedImage bufferedImage = ImageIO.read(in);
		ImageIO.write(bufferedImage, type, out);
		return bufferedImage;
	}

}
