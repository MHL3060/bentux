package local.tux;

import java.beans.PropertyEditorSupport;

import local.tux.app.model.common.TuxBaseObject;
import local.tux.app.service.LookUpNameGenericManager;

import org.appfuse.service.GenericManager;

/**
 * converting POJO's reference object for spring MVC.
 * @author Ben Li
 *
 */
public class TuxBaseObjectConverter extends PropertyEditorSupport {

	@SuppressWarnings("unchecked")
	private GenericManager genericManager = null;
	@SuppressWarnings("unchecked")
	
	public TuxBaseObjectConverter(GenericManager genericManager){
		this.genericManager = genericManager;
	}
	
	public GenericManager getGenericManager(){
		if (genericManager == null ) {
			throw new RuntimeException("Didn't set GenericManager");
		}
		return genericManager;
	}
	
	@SuppressWarnings("unchecked")
	public void setGenreicManager(GenericManager genericManager){
		this.genericManager = genericManager;
	}
	@SuppressWarnings("unchecked")
	public void setAsText(String text){
		if ("".equals(text)){
			setValue(null);
		}else {
			int i = Integer.parseInt(text);
			setValue(genericManager.get(new Long(i)));
		}
	}
	public String getAsText(){
		TuxBaseObject to = (TuxBaseObject) getValue();
		if (to == null || to.getId() == null){
			return "";
		}else {
			TuxBaseObject operator = (TuxBaseObject) getValue();
			return "" + operator.getId();
		}
	}
	@SuppressWarnings("unchecked")
	protected Object convertElement(Object element){
		
		if ( element != null){
			Long id = new Long((String)element);
			TuxBaseObject object = (TuxBaseObject) genericManager.get(id);
			return object;
		}
		return null;
	}
}


