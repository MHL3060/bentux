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
	public final String DELETE_ACTION = "delete";
	public final String EDIT_ACTION = "edit";
	public final String ACTION_PARAM = "action";
	public final String SAVE_ACTION = "save";
	public final List<TuxBaseObject> EMPTY_LIST = new ArrayList<TuxBaseObject>();
	
	public final int CATALOG_FOOD_PRODUCT = -1;
	public final int CATALOG_ENTERTAIN_PRODUCT = -2;
	public final int CATALOG_ENTERTAIN_SERIVCE = -3;
	public final int CATALOG_CULTURAL_PRODUCT = -4;
	public final int AJAX_SIZE = 25;
	
	public final int NEWS_BACK_TO = -30;
	public final int NEWS_DISPLAY_ITEM = 5;
	public final int SEARCH_SHOW_CHARACTER_LENGTH = 1000;
	public final String CHECK_OUT = "checkout";
	
	public enum  CART_STATUS {OPEN, SUBMITTED, PROCESSING, SHIPPED};
	
	public enum ShippingType {PICKUP, DELIVERY};
	
	
	public final String IMAGE_TYPE = "image";
	public final String THUMB_TYPE = "thumb";
	
	
	public final String ADDRESS_SESSION = "address";
	public final String CANCEL_ACTION = "cancel";
	public final int MULTIPLE_COUNT = 10;
	
	public final int MAX_CATALOG_LEVEL = 3;
	
}
