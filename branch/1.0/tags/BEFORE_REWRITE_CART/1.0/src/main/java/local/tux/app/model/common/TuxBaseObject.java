package local.tux.app.model.common;


import local.tux.app.converter.TuxBaseObjectConverter;

import org.appfuse.model.BaseObject;

public abstract class TuxBaseObject extends BaseObject implements Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8144896819500362996L;
	/**
	 * this abstract class is used for {@link TuxBaseObjectConverter}
	 * @return
	 */
	public abstract Long getId();
	public abstract void setId(Long id);
}
