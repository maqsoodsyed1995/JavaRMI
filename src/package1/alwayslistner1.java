package package1;
import package1.server1code;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class alwayslistner1 extends Thread {
	
		public int count;
		private int c=0,d=0;
		String date;
		public alwayslistner1 (int c ,int d, String date)
		{ 
			
			this.c=c;
			this.d=d;
			this.date=date;
		}
		public void run() 
		{
	
			
			DatagramSocket dSocket = null;
			try
			{   
				int i=server1code.rc;
		           
				  
					dSocket = new DatagramSocket(d);
					byte[] buffer4 = new byte[1000];
					buffer4=Integer.toString(i).getBytes();
					while(true)
					{
						
						{DatagramPacket request2 = new DatagramPacket(buffer4, buffer4.length);
							DatagramPacket request4 = new DatagramPacket(buffer4, buffer4.length);
							
							dSocket.receive(request4);
							
							DatagramPacket reply = new DatagramPacket(request2.getData(),
							request2.getLength(), request4.getAddress(), request4.getPort());
							dSocket.send(reply);
						}
						
						
					}
			}
			catch (SocketException e)
			{
					System.out.println("Socket: " + e.getMessage());
			}
			catch (IOException e)
			{
				System.out.println("IO: " + e.getMessage());
				
			}
		
		    finally 
		   {
			if(dSocket != null) 
				dSocket.close();}
	     	}
		
		}
		



