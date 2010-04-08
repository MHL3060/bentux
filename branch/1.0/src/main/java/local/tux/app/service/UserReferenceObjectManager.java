package local.tux.app.service;

import java.io.Serializable;
import java.util.List;

import org.appfuse.model.User;



public interface UserReferenceObjectManager<UserReference, PK extends Serializable> extends LookUpNameGenericManager<UserReference, PK> {

	public List<UserReference> getObjectsByUser(User user);
}
