package local.tux.app.web.controller;


import java.awt.Dimension;
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

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cedarsoft.image.ImageConverter;


import local.tux.Constants;
import local.tux.TuxBaseObjectConverter;
import local.tux.app.model.Image;
import local.tux.app.model.Product;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class ImageFormController extends TuxBaseFormController {

	private LookUpNameGenericManager productManager;
	//private LookUpNameGenericManager imageManager;
	public ModelAndView processFormSubmission(HttpServletRequest request, HttpServletResponse response,
            Object command, BindException errors) throws Exception {
		if (request.getParameter("cancel") != null) {
			return new ModelAndView(getCancelView());
		}
		
		return super.processFormSubmission(request, response, command, errors);
	}
	public void setProductManager(LookUpNameGenericManager productManager){
		this.productManager = productManager;
	}
	
	@SuppressWarnings("unchecked")
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		Object object = super.formBackingObject(request);
		String pid = request.getParameter("pid");
		if (StringUtils.isBlank(pid)== false){
			((Image)object).setProduct((Product) productManager.get(new Long(pid)));
		}
		return object;
	} 
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		super.initBinder(request, binder);
		TuxBaseObjectConverter projectEditor = new TuxBaseObjectConverter(productManager);
		
		binder.registerCustomEditor(Product.class, projectEditor);
	}

	public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, 
			Object command, BindException errors) throws Exception {
		
		String docBase = request.getSession().getServletContext().getRealPath("/");
		Image image = (Image) command;
		
		boolean isNew = image.getId() == null;
		if (StringUtils.isBlank(request.getParameter(Constants.CANCEL_ACTION)) == false ) {
			return showForm(request, response, errors);
		}else if (request.getParameter(Constants.DELETE_ACTION) != null){
			if (deleteFile(docBase, image)){
				saveMessage(request, getText("image.deleted", request.getLocale()));
			}
		}else if (!isNew) {
			Image persistImage = (Image) lookUpManager.get(image.getId());
		}
		if (isNew && image.getFile().length == 0) {
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
		fileName = fileName.replaceAll(" ", "");
		String type = tokens[tokens.length -1];
		image.setPath(Constants.IMAGE_PATH +"/"+ fileName);
		FileOutputStream out = new FileOutputStream(docBase + image.getPath());
		ImageInputStream in = new MemoryCacheImageInputStream(file.getInputStream());
		BufferedImage originalImage = saveFile(in, type, out);
        out.close();
        ImageConverter converter = new ImageConverter();
		BufferedImage thumbnail = converter.resize(originalImage, new Dimension(Constants.THUMBNAIL_WIDTH, Constants.THUMBNAIL_HEIGHT));
		image.setThumbPath(Constants.IMAGE_PATH + "/thumbs/" + fileName);
		
		out = new FileOutputStream(docBase + image.getThumbPath());
		ImageIO.write(thumbnail, type, out);
		out.close();
			
		return super.onSubmit(request, response, image, errors);
		
	}
	private boolean deleteFile(String docBase, Image image){
		File f = new File(docBase + File.separatorChar + image.getPath());
		File thumbF = new File(docBase + File.separatorChar + image.getThumbPath());
		return f.delete() && thumbF.delete();
	}
	private BufferedImage saveFile(ImageInputStream in, String type, OutputStream out) throws IOException {
		
		BufferedImage bufferedImage = ImageIO.read(in);
		ImageIO.write(bufferedImage, type, out);
		return bufferedImage;
	}

}