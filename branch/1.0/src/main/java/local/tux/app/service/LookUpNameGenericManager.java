package local.tux.app.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;

import org.appfuse.service.GenericManager;

public interface LookUpNameGenericManager<T, PK extends Serializable> extends GenericManager<T, PK> {

	public T getLookUpBaseObject(String name);
	
	public List<TuxBaseObject> getRelativeObjects( String key, Long value);
	
	public List<T> search(String propertyName, String value);
	public int getAllRecordsCount();
	
	public List<T> getItemsInInterval(String attribute, Object from, Object to);
}
