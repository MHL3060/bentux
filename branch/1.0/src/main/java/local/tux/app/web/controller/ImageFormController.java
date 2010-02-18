package local.tux.app.web.controller;


import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;


import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import local.tux.Constants;
import local.tux.ThumbnailFactory;
import local.tux.TuxBaseObjectConverter;
import local.tux.app.model.Image;
import local.tux.app.model.Product;
import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;
import local.tux.app.web.common.controller.TuxBaseFormController;

public class ImageFormController extends TuxBaseFormController {

	private LookUpNameGenericManager productManager;
	private String imagePath;
	private final String THUMB_PATH = "/thumbs";
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
	public void setStoreImagePath(String imagePath){
		this.imagePath = imagePath;
		createDirIfNotExist(imagePath);
		createDirIfNotExist(imagePath + THUMB_PATH );
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
		
		TuxBaseObjectConverter projectEditor = new TuxBaseObjectConverter(productManager);
		
		binder.registerCustomEditor(Product.class, projectEditor);
		
		super.initBinder(request, binder);
	}

	public ModelAndView onSubmit(HttpServletRequest request,HttpServletResponse response, 
			Object command, BindException errors) throws Exception {
		
		String docBase = request.getSession().getServletContext().getRealPath("/");
		Image image = (Image) command;
		
		boolean isNew = image.getId() == null;
		if (request.getParameter(Constants.DELETE_ACTION) != null){
			if (deleteFile(docBase, image)){
				saveMessage(request, getText("image.deleted", request.getLocale()));
			}
		}else if (!isNew) {
			Image persistImage = (Image) lookUpManager.get(image.getId());
		}
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
			fileName = fileName.replaceAll(" ", "");
			String type = tokens[tokens.length -1];
			image.setPath(imagePath +THUMB_PATH +"/"+ fileName);
			FileOutputStream out = new FileOutputStream(docBase + image.getPath());
			ImageInputStream in = new MemoryCacheImageInputStream(file.getInputStream());
			BufferedImage originalImage = saveFile(in, type, out);
	        out.close();
			
			BufferedImage thumbnail = ThumbnailFactory.getThumbnail(originalImage, Constants.THUMBNAIL_WIDTH, Constants.THUMBNAIL_HEIGHT);
			
			image.setThumbPath(imagePath + "/thumbs/" + fileName);
			
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

	private void createDirIfNotExist(String path){
		File f = new File(path);
		if (f.exists() == false) {
			f.mkdir();
		}
	}
}
