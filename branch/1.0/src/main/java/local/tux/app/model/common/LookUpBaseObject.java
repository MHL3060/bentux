package local.tux.app.model.common;



public abstract class LookUpBaseObject extends TuxBaseObject {

	/**
	 * Look up model.
	 */
	private static final long serialVersionUID = -5701153726564577421L;
	public abstract String getName();
	public abstract void setName(String name);
	
	public String toString(){
		return new StringBuffer("id : ").append(getId()).
						append(" name : ").append(getName()).toString();
	}

}
