package client_package;
import java.io.*;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import package1.server1interface;
import package2.server2interface;
import package3.server3interface;


public class mainclass {

	public static void main(String[] args) throws Exception {
		
		int x;
		String id;
		server1interface s1;
		server2interface s2;
		server3interface s3;
		s1=(server1interface)Naming.lookup("rmi://localhost:25011/tag1");
		s2=(server2interface)Naming.lookup("rmi://localhost:25012/tag2");
		s3=(server3interface)Naming.lookup("rmi://localhost:25013/tag3");
		System.out.println("press 1 to Acces the system \n press 2 to stop the system"); 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		x=Integer.parseInt(br.readLine());
		if(x==1)
		{
			System.out.println("Enter your id");
			id=br.readLine();
			if(id.charAt(3)=='S'||id.charAt(3)=='S')
				{
					studentclass sc=new studentclass();
					sc.student(id,s1,s2,s3);
				}
			else if(id.charAt(3)=='A'||id.charAt(3)=='a')
			{
				adminclass ac=new adminclass();
				ac.admin(id,s1,s2,s3);
			}
			else
			{
				System.out.println("Enter a valid id");
			}	
				
				
				
			
		}
		else if(x==2)
		{
			System.exit(0);
		}
		else
		{
			
			System.out.println("You have chosen the wrong option");
			
		}
		
		}
	}


