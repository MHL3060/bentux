package local.tux.app.webapp.tag;

import java.io.OutputStream;
import java.util.Stack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import local.tux.app.model.Catalog;
import local.tux.app.model.Product;

import org.displaytag.tags.el.ExpressionEvaluator;


public class CatalogTag extends TagSupport {

	private Product product;
	public void setProduct(Product product) {
        this.product = product;
    }
	public int doStartTag() throws JspException {
		Catalog pCatalog = product.getCatalogs().iterator().next();
		Catalog parent = pCatalog.getParent();
		
		Stack<String> stacks = new Stack<String>();
		do {
			stacks.push(generateSelect(parent, pCatalog.getId()));
			pCatalog = parent;
			parent = parent.getParent();
		}while (parent != null);
		
		JspWriter writer = pageContext.getOut();
		try {
			String s;
			while (stacks.empty() ==false){
				
				writer.write(stacks.pop());
			}
		}catch (Exception e){
			throw new JspException(e);
		}
		return super.doStartTag();
		
	}
	
	private String generateSelect(Catalog catalog, Long selectedId){
		
		StringBuffer select = new StringBuffer("<li class='catalog' id='li_catalog_")
									   .append(catalog.getId())
									   .append("'>")
									   .append("<label class='desc'>Catalog</label>")
									   .append("<select name='catalog_")
									   .append(catalog.getId())
									   .append("' onchange='addSelect(this); checkMySelect(this);'>");
		
		for (Catalog c : catalog.getChildren()){
			select.append("<option value='")
				  .append(c.getId())
				  .append("'")
				  .append(selectedId == c.getId()? " selected>" : ">")
				  .append(c.getName())
				  .append("</option>");
		}
		select.append("</select></li>");
		return select.toString();
									   
	}
	
	
	
	
}
