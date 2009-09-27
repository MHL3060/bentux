package local.tux.app.service;

import java.io.Serializable;
import java.util.List;

import local.tux.app.model.common.LookUpBaseObject;
import local.tux.app.model.common.TuxBaseObject;

import org.appfuse.service.GenericManager;

public interface LookUpNameGenericManager<T, PK extends Serializable> extends GenericManager<T, PK> {

	public T getLookUpBaseObject(String name);
	
	public List<TuxBaseObject> getRelativeObjects( String key, Long value);
}
