package local.tux.app.model.common;

import java.io.Serializable;

import org.appfuse.model.BaseObject;

public abstract class TuxBaseObject extends BaseObject {

	public abstract Long getId();
	public abstract void setId(Long id);
}
