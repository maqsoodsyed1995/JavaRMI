package client_package;
import java.io.*;
import package1.server1interface;
import package2.server2interface;
import package3.server3interface;


public class adminclass {
	

	
	public void admin(String Id,server1interface server1,server2interface server2,server3interface server3)throws IOException
	{
		int k;
		String roomnumber,date,timeslot;
		boolean result;
        String s1=new String("DVL");
		String s2=new String("KKL");
		String s3=new String("WST");
	     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	     String c_name=Id.substring(0,3);
	     System.out.println("Press 1 to create  reccord ,Press 2 to delete record ");
	     k=Integer.parseInt(br.readLine());
	if(k==1)
	{
		
		
	
		 System.out.println("enter Date");
		 date=br.readLine();
		 System.out.println("enter roomnumber");
	     roomnumber=(br.readLine()); 
	     System.out.println("Enter the slot ");
		 timeslot=br.readLine();
		 if(c_name.equals(s1))
    	 {	
			       result=server1.createroom(roomnumber,date,timeslot);
			       if(result)
		           System.out.println("Room Created");  
			       else			        
				    System.out.println("Unsuccesful attempt in room creation");	
    	}
    	else if(c_name.equals(s2))
    	{
    		       result=server2.createroom(roomnumber,date,timeslot);
		           if(result)
	                System.out.println("Room Created");  
		           else			        
			       System.out.println("Unsuccesful attempt in room creation");	
    		
    	}
    	else if(c_name.equals(s3))
    	{
    		       result=server3.createroom(roomnumber,date,timeslot);
		           if(result)
	               System.out.println("Room Created");  
		           else			        
			       System.out.println("Unsuccesful attempt in room creation");	
	     }
	
	else if(k==2)
	    {
		      System.out.println("Enter Date ");
		      date=br.readLine();
		      System.out.println("Enter roomnumber ");
	          roomnumber=(br.readLine());
	          System.out.println("Enter the slot"); 
		      timeslot=br.readLine(); 
		      if(c_name.equals(s1))
      	      {	
			            result=server1.deleteroom(roomnumber,date,timeslot);
			            if(result)
				        System.out.println("Room Deleted");
			            else
				        System.out.println("unsuccesfull attempt to delete the room");
			
             }
    	     else if(c_name.equals(s2))
    	     {
    	    	       result=server2.deleteroom(roomnumber,date,timeslot);
		               if(result)
			           System.out.println("Room Deleted");
		               else
			           System.out.println("unsuccesfull attempt to delete the room");
    	     } 
    	     else if(c_name.equals(s3))
    	     {           
    	    	        result=server2.deleteroom(roomnumber,date,timeslot);
	                    if(result)
		                System.out.println("Room Deleted");
	                    else
		                System.out.println("unsuccesfull attempt to delete the room");
    	     }
    		             
    	}
	
	}
}	}

