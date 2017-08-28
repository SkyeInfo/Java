package Meetingrmi;
/*define remote interface 
 * @author basara 
 * */
import java.rmi.*;
import java.sql.SQLException;

public interface ServiceInterface extends Remote {
	public boolean register(String userName, String password)
			throws RemoteException, SQLException;

	public boolean add(String userName, String password, String schedule_user,
					   String title, String label, String startTime, String endTime)
			throws RemoteException;

	public String[] query(String userName, String start, String end)
			throws RemoteException, SQLException;

	public boolean delete(String userName, int meetingID)
			throws RemoteException, SQLException;

	public boolean clear(String userName) throws RemoteException;
}
