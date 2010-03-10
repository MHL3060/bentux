package local.tux.app.model.web;

public class SearchResultBean {
	
	private Long id;
	private String ObjectName;
	private String name;
	private String resource;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObjectName() {
		return ObjectName;
	}
	public void setObjectName(String objectName) {
		ObjectName = objectName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	
}
