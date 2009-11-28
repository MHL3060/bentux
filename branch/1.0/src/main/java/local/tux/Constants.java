package local.tux;

import java.util.ArrayList;
import java.util.List;

import local.tux.app.model.common.TuxBaseObject;


public interface Constants {

	
	public final int THUMBNAIL_WIDTH = 100;
	public final int THUMBNAIL_HEIGHT = 100;
	public final static String IMAGE_PATH = "/images/app";
	public final String DATE_PATTERN = "MM/dd/yyyy";
	public final int PAGE_SIZE = 25;
	public final String[] EDIT_PERMISSION = {org.appfuse.Constants.ADMIN_ROLE };  
	public final String[] WEIGHT_UNIT = {"oz", "lb", "kg", "g", "ml", "l"};
	public final String DELETE_OBJECT = "delete";
	public final List<TuxBaseObject> EMPTY_LIST = new ArrayList<TuxBaseObject>();
	
	public final int CATALOG_FOOD_PRODUCT = -1;
	public final int CATALOG_ENTERTAIN_PRODUCT = -2;
	public final int CATALOG_ENTERTAIN_SERIVCE = -3;
	public final int AJAX_SIZE = 25;
	
	public final int NEWS_BACK_TO = -30;
	public final int NEWS_DISPLAY_ITEM = 5;
	
}
