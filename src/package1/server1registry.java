package package1;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
public class server1registry {

		public static void main(String args[]) throws RemoteException
		{
			server1code serv1=new server1code();
			Registry re=java.rmi.registry.LocateRegistry.createRegistry(25011);
			re.rebind("tag1", serv1);
			System.out.println("server1 is binded");
		}
	}