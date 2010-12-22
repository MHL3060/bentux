package local.tux.app.webapp.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

import local.tux.app.model.Catalog;

public class CatalogMultipleMenuTag extends TagSupport {

	
	private Catalog catalog;
	private String mouseOverEvent;
	private String onClickEvent;

	public void setCatalog(Catalog catalog){
		this.catalog = catalog;
	}
	
	public void setMouseOver(String mouseOverEvent){
		this.mouseOverEvent = mouseOverEvent;
	}
	public void setOnClick(String onClickEvent){
		this.onClickEvent = onClickEvent;
	}
	public int doStartTag() throws JspException{
		
		
		
		
		try {
			pageContext.getOut().write(generateList(catalog));
		} catch (IOException e) {
			
			
			throw new JspException(e);
		}
		
		
		
		return super.doStartTag();
	}
	
	
	private String generateList(Catalog catalog){
		List<Catalog> catalogs = catalog.getChildren();
		StringBuffer sb = new StringBuffer();
		if (catalogs.isEmpty() == false){
			sb.append("<ul class='nice_menu' ")
			  .append(" id='")
			  .append(catalog.getId())
			  .append("'>");
		}
		for (Catalog c : catalogs){
			sb.append("<li><a href='#'");
			if (StringUtils.isBlank(onClickEvent) == false){
				sb.append("onclick='")
				  .append(onClickEvent)
				  .append("'");
			}
			sb.append(" >");
			sb.append(c.getName());
			if (c.getChildren().isEmpty() == false){
				sb.append(" +");
			}
			  sb.append("</a>");
			sb.append(generateList(c));
			sb.append("</li>");
		}
		if(catalogs.isEmpty() ==false){
			sb.append("</ul>");
		}
		return sb.toString();
	}
	
	
	
}
