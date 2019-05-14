package package2;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
public class server2registry {

		public static void main(String args[]) throws RemoteException
		{
			server2code serv2=new server2code();
			Registry re=java.rmi.registry.LocateRegistry.createRegistry(25012);
			re.rebind("tag2", serv2);
			System.out.println("server2 is binded");
		}
	}



