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
        
       return (DetachedCriteria) clone(criteria);
    }
	/**
	 * Convenient function to convert POJO that didn't implement clonable but implement serializable.
	 * 
	 * @param obj
	 * @return
	 * @throws Exceptions
	 */
	public static Object clone(Object obj) throws Exception{
		ByteArrayOutputStream baostream = new ByteArrayOutputStream();
        ObjectOutputStream oostream = new ObjectOutputStream(baostream);
        oostream.writeObject(obj);
        oostream.flush();
        oostream.close();
        ByteArrayInputStream baistream = new ByteArrayInputStream(baostream.toByteArray());
        ObjectInputStream oistream = new ObjectInputStream(baistream);
        Object copy = oistream.readObject();
        oistream.close();            
        return copy;
	}
}
