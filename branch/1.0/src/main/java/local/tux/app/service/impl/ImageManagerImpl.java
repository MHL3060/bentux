package local.tux.app.service.impl;

import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.dao.LookupDao;

import local.tux.app.model.Image;
import local.tux.app.service.ImageManager;
import local.tux.app.service.LookUpNameGenericManager;

public class ImageManagerImpl extends LookUpNameGenericManagerImpl<Image, Long> implements
		ImageManager {

	
	public ImageManagerImpl(GenericDao<Image, Long> genericDao) {
		super(genericDao);
		
	}

	public Image getByName(String name) {
		List<Image> images = genericDao.getItems("name", name);
		if (images.size() > 0){
			return images.get(0);
		}else {
			return null;
		}
	}

	

}
