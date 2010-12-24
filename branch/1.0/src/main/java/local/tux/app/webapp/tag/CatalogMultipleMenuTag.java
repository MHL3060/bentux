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
			pageContext.getOut().write(generateList(catalog, true));
		} catch (IOException e) {
			
			
			throw new JspException(e);
		}
		
		
		
		return super.doStartTag();
	}
	
	
	private String generateList(Catalog catalog, boolean first){
		List<Catalog> catalogs = catalog.getChildren();
		StringBuffer sb = new StringBuffer();
		if (catalogs.isEmpty() == false){
			if (first){
				sb.append("<ul class='flexdropdownmenu' ")
				  .append(" id='ul_")
				  .append(catalog.getId())
				  .append("'>");
			}else {
				sb.append("<ul>");
			}
		}
		for (Catalog c : catalogs){
			sb.append("<li><a href='#'");
			sb.append(" onclick=\"showProduct('")
			  .append(c.getId())
			  .append("','products'); document.getElementById('product_table').style.borderCollapse='collapse'\" ");
			sb.append(" >");
			sb.append(c.getName());
			sb.append("</a>");
			sb.append(generateList(c, false));
			sb.append("</li>");
		}
		if(catalogs.isEmpty() ==false){
			sb.append("</ul>");
		}
		return sb.toString();
	}
	
	
	
}
