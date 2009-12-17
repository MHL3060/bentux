package local.tux;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.hibernate.criterion.DetachedCriteria;

public class HibernateUtil {

	/**
	 * cloning a criteria. throws an exception if the criteria can't be copy.
	 * @param criteria
	 * @return
	 */
	public static DetachedCriteria copy(DetachedCriteria criteria) throws Exception {
        
        ByteArrayOutputStream baostream = new ByteArrayOutputStream();
        ObjectOutputStream oostream = new ObjectOutputStream(baostream);
        oostream.writeObject(criteria);
        oostream.flush();
        oostream.close();
        ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray());
        ObjectInputStream oistream = new ObjectInputStream(baistream);
        DetachedCriteria copy = (DetachedCriteria)oistream.readObject();
        oistream.close();            
        return copy;
    }
}
