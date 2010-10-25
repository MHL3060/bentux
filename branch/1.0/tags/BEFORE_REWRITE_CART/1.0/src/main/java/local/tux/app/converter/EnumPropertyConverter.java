package local.tux.app.converter;

import java.beans.PropertyEditorSupport;
import java.util.EnumMap;

import org.apache.commons.lang.enums.EnumUtils;
import org.compass.core.converter.basic.EnumConverter;

import local.tux.Constants.CART_STATUS;
import local.tux.app.model.common.TuxBaseObject;

public class EnumPropertyConverter extends PropertyEditorSupport{

	private Enum[] es;
	public EnumPropertyConverter(Enum[] es){
		this.es = es;
	}
	 public void setAsText(String text) throws IllegalArgumentException {
        for(Object e : es){
            if(e.toString().equals(text)){
                setValue(e);
                return;
            }
        }
        throw new IllegalArgumentException("Invalid text for enum of type '" + es + ": '" + text + "'.");
    }
}
