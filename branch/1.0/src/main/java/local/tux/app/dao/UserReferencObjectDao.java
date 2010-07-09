package local.tux.app.dao;

import java.io.Serializable;
import java.util.List;

import org.appfuse.dao.GenericDao;
import org.appfuse.model.User;

public interface UserReferencObjectDao<T, PK extends Serializable> extends TuxNameGenericDao<T, PK> {
	
	public List<T> getObjectsByUser(User user);

	
}
