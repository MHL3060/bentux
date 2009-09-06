package local.tux.app.service;

import local.tux.app.model.common.LookUpBaseObject;

import org.appfuse.service.GenericManager;

public interface LookUpNameGenericManager extends GenericManager<LookUpBaseObject, Long> {

	public LookUpBaseObject getLookUpBaseObject(String name);
}
