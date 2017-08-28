package Meetingrmi;
/*server of RMI*/
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	private static int PORT = 8099;

	public static void main(String[] args) {

		String registryURL = "rmi://localhost:"+PORT+"/RMIServer";
		try {
			ServiceImpl service = new ServiceImpl();
			LocateRegistry.createRegistry(PORT);
			Naming.bind(registryURL, service);
			System.out.println("-->Service Started");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
