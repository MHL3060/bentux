package local.tux.app.model.common;

import java.io.Serializable;

import org.appfuse.model.BaseObject;

public abstract class TuxBaseObject extends BaseObject {

	public abstract Serializable getId();
	public abstract void setId(Serializable id);
	

}
