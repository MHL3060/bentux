package local.tux.app.service;

import java.io.Serializable;

import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.service.GenericManager;

public interface LookUpNameGenericManager<T, PK extends Serializable> extends GenericManager<T, PK> {

	public T getLookUpBaseObject(String name);
}
