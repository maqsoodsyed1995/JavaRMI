package package3;
import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import package2.server2interface;
import package3.server3interface;
import package1.alwayslistner1;
import package1.sender1;

public class server3code extends UnicastRemoteObject implements server3interface {
	
	HashMap<String,HashMap<String,HashMap<String,String>>> hm1=new HashMap<String,HashMap<String,HashMap<String,String>>>();
	HashMap<String,HashMap<String,String>> hm2=new HashMap<String,HashMap<String,String>>();
	HashMap<String,String> hm3=new HashMap<String,String>();   
	HashMap<String,ArrayList<String>> hm4=new HashMap<String,ArrayList<String>>();
	ArrayList<String> al=new ArrayList<String>();
	double w1;
	int i=0,cou=0;
	String bookingid,date,roomnumber,t_slot;
	server2interface si2;
	server3interface si3;
	static int rc=0;
	

	public server3code() throws  RemoteException
	{
		super();
	}
	public void listener(int a,int b,String date) throws RemoteException
	{
		
		alwayslistner3 tl1=new alwayslistner3(cou,a,date);
		Thread t3=new Thread(tl1);
		t3.start();
	
	}
	public boolean createroom(String roomnumber,String date,String t_slot)throws RemoteException
	{
		
		
		Set<String> srn=hm2.keySet();
		Set<String> st=hm3.keySet();
		Iterator irn=srn.iterator();
		Iterator sit=st.iterator();
		while(irn.hasNext())
		{	
			String s=(String)irn.next();
			if(s.equals(roomnumber))
				{
					while(sit.hasNext())
					{
		                String s1=(String)sit.next();
						if(s1.equals(t_slot))
						{
							System.out.println("t_slot Already Exists");
						return false;
						}
					}
				}
		}
			
				hm3.put(t_slot,"Available");
				hm2.put(roomnumber,hm3);
				hm1.put(date,hm2);	
				rc++;
		
		return true;
	}	
	public boolean deleteroom(String roomnumber, String date, String t_slot)throws RemoteException
	{
		
		hm1.get(date).get(roomnumber).remove(t_slot);
		rc--;
		return true;
	}
		
	public String bookroom(String campusName,String roomnumber,String date,String t_slot,String UID)throws RemoteException
	{
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int i=0;

		

		try
		{  
			if(hm4.isEmpty())
			{
				al.add("UID");
				hm4.put(UID,al);
			}
			Set<String> st1=hm4.keySet();
			Iterator sit=st1.iterator();
			while(sit.hasNext())
			{
			
				String s=(String)sit.next();
			
				if(UID==s)
				{
					i++;
				}
			}
			if(i==0)
			{
				al.add("UID");
				hm4.put(UID,al);
				i=0;
			}
			
			if(hm4.get(UID).size()>3)
			{	System.out.println("You have reached the booking limit already");
				return "";
			}
			else
			{
				si2=(server2interface)Naming.lookup("rmi://localhost:25012/tag2");
				si3=(server3interface)Naming.lookup("rmi://localhost:25013/tag3");
				if(campusName.equals(new String("DVL")))
				{
					bookingid = UUID.randomUUID().toString();
					
					hm1.get(date).get(roomnumber).put(t_slot,bookingid);
					rc--;
					System.out.println("booked");
				}
				else if(campusName==new String("KKL"))
				{
					bookingid=si2.bookroom(campusName,roomnumber,date,t_slot,UID);
				}
				else if(campusName==new String("WST"))
				{
					bookingid=si3.bookroom(campusName,roomnumber,date,t_slot,UID);
				}
			}
			hm4.get(UID).add(bookingid);
			
		}
	catch(NotBoundException e ) 
		{
			
		}
	catch (MalformedURLException e)
		{
		}
	return bookingid;
	}		
	
	public int getAvailableTimeSlot ( String date)throws RemoteException, InterruptedException
	{ 
		
		try
	{
			si2=(server2interface)Naming.lookup("rmi://localhost:25012/tag2");
			si3=(server3interface)Naming.lookup("rmi://localhost:25013/tag3");
			si2.listener(2150,0,date);
			si3.listener(2160,0,date);
			
	}
		catch(NotBoundException e ) 
		{
			System.err.println(e);
		}
	catch (MalformedURLException e)
		{
		System.err.println(e);
		}
	
		
		String sc1,sc2;
		
		String s3="Available";
		cou=0;
		
	/*	Set<String> set= a.get(date).keySet();
		Iterator it=set.iterator();
		while(it.hasNext())
		{
			String s =(String)it.next();
			Set<String> set1 =	a.get(date).get(s).keySet();
			Iterator it1 =set1.iterator();
			while(it1.hasNext())
			{
				String s1=(String)it1.next();
				if(s3.equals(a.get(date).get(s).get(s1)));
				cou++;
			}
		}*/
		System.out.println("Server1: local count -" + rc);
		sender1 ts1=new sender1(cou,2150);
		sender1 ts2=new sender1(cou,2160);
		Thread t1=new Thread(ts1);
		Thread t2=new Thread(ts2);
		
		
		t1.start();
		t2.start();	
		//while (ts1.ready && ts2.ready) {
			//int total=ts1.count + ts2.count;}
		sc1=ts1.d1;
		sc2=ts2.d1;
		System.out.println("Server1: others count -" + sc1+"-"+sc2);
		t1.join();
		t2.join();
		
		sc1=ts1.d1;
		sc2=ts2.d1;
		System.out.println("Server1: others count -" + sc1+"-"+sc2);
		
return rc;
		
	}
	  public void cancelBooking (String bookingID)throws RemoteException
	  {
		  int c=0;
			String s3=bookingID;
			Set<String> st0= hm1.keySet();
			Iterator t0=st0.iterator();
			while(t0.hasNext())
			{
			String s=(String)t0.next();
			Set<String> st1 =	hm1.get(s).keySet();
			Iterator t1 =st1.iterator();
			while(t1.hasNext())
			{
				String s1=(String)t1.next();
				Set<String> st2=hm1.get(s).get(s1).keySet();
				Iterator t2=st2.iterator();
				while(t2.hasNext())
				{
					String s2=(String)t2.next();
					if(s3.equals(hm1.get(s).get(s1).get(s2)));
					{	
						hm1.get(s).get(s1).remove(s2);
						System.out.println("Booking cancellation was successful");
						rc++;
					}
						
				}
			}
			}
			Set<String> st3= hm4.keySet();
			Iterator t3=st3.iterator();
			while(t3.hasNext())
			{
				String s4=(String)t3.next();
				for(i=0;i<3;i++)
				{
					if(bookingID==hm4.get(s4).get(i))
					hm4.get(s4).remove(i);	
				}
							
			}
	  }
}