package local.tux.app.service;

import local.tux.app.model.Image;

public interface ImageManager extends LookUpNameGenericManager<Image, Long>{
	
	public Image getByName(String name);

}
