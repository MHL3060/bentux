package local.tux.app.model.common;


import local.tux.TuxBaseObjectConverter;

import org.appfuse.model.BaseObject;

public abstract class TuxBaseObject extends BaseObject {

	/**
	 * this abstract class is used for {@link TuxBaseObjectConverter}
	 * @return
	 */
	public abstract Long getId();
	public abstract void setId(Long id);
}
