package client_package;
import java.io.*;
import java.lang.*;
import package1.server1interface;
import package2.server2interface;
import package3.server3interface;
public class studentclass
{

		
			public void student(String Id,server1interface server1,server2interface server2,server3interface server3)throws IOException, InterruptedException
			{
						
			            String roomnumber,bookingid,campus,campusid,date,timeslot;
						int opt,tslots;
						String s1=new String("DVL");
						String s2=new String("KKL");
						String s3=new String("WST");
						BufferedReader br= new BufferedReader(new InputStreamReader(System.in));     
			            System.out.println("Select 1 to book a room\n Select 2 to get available timeslot,Select 3 to cancelbooking");
			            campusid=Id.substring(0,3);
			            opt=Integer.parseInt(br.readLine());
	        	               if(opt==1)
	        
	        	               {
				        				System.out.println("Enter campusname");
					        			campus=br.readLine();
				        				System.out.println("Enter Date");
					        			date=br.readLine();
					        			System.out.println("Enter roomnumber");
					        			roomnumber=br.readLine();
					        			System.out.println("Enter timeslot");
				        	            timeslot=br.readLine();
				        	            	if(campusid.equals(s1))
				        	            			{	
				        	            				bookingid=server1.bookroom(campus, roomnumber, date, timeslot,Id);
	        		
				        	            				System.out.println("your booking id is "+bookingid);
				        	            			}
				        	            	else if(campusid.equals(s2))
				        	            			{
				        	            				bookingid=server2.bookroom(campus, roomnumber, date,timeslot,Id);
				        	            				System.out.println("your booking id is "+bookingid);
				        	            			}
				        	            	else if(campusid.equals(s3))
				        	            			{
				        	            				bookingid=server3.bookroom(campus, roomnumber, date, timeslot,Id);
				        	            				System.out.println("your booking id is "+bookingid);
	        	
				        	            			}
	        	               }
	        
	        	               else if(opt==2)
	        	               						{
	        	            	   						System.out.println("enter the date");
	        	            	   						date=br.readLine();
	        	            	   						if(campusid.equals(s1))
	        	            	   						{	
	        		
	        	            	   							tslots=server1.getAvailableTimeSlot(date);
	        	            	   							System.out.println(tslots);
	        	            	   						}
					          	   						else if(campusid.equals(s2))
											        	{
											        		tslots=server2.getAvailableTimeSlot(date);
											        		System.out.println(tslots);
											        	}
											        	else if(campusid.equals(s3))
											        	{
											        		tslots=server3.getAvailableTimeSlot(date);
											        		System.out.println(tslots);
											        	}
	        	
	        	
	        	               						}
	        	               else if(opt==3)
											        	{
											        		System.out.println("enter the bookind id provided at the time of booking");
											        		bookingid=br.readLine();
											        		if(campusid.equals(s1))
											        	{	
											        			server1.cancelBooking(bookingid);	
											        			
											        	}
											        		
											        	else if(campusid.equals(s2))
											        	{
										
											        		server2.cancelBooking(bookingid);	
											        	}
											        	else if(campusid.equals(s3))
											        	{
											        		server3.cancelBooking(bookingid);	
											        	}
	        	
	        	
											        	}
	                            }
			}
			
			

		
	
