package local.tux.app.service.cron;


/**
 * This is the scheduling component.
 * In order to wirte a cron task
 * 
 *  1). you must implement this interface.
 *  
 * 	2). open applicationContext-cron.xml and register your crontask.
 * @author Ben Li
 *
 */
public interface TuxCronTask {

	/**
	 * 
	 * @throws Exception
	 */
	public void execute() throws Exception;
	
}
