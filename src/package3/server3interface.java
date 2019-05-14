package package3;

public interface server3interface {


	public  boolean createroom(String roomnumber,String date,String timeslot)throws java.rmi.RemoteException;;
	public boolean deleteroom(String rno, String date, String timeslot)throws java.rmi.RemoteException;;
	public 	String bookroom(String campusName,String rno,String date,String timeslot,String UID)throws java.rmi.RemoteException;;
    public int getAvailableTimeSlot ( String date)throws java.rmi.RemoteException, InterruptedException;;
    public void cancelBooking(String bookingID)throws java.rmi.RemoteException;;
    public void listener(int a,int b,String date) throws java.rmi.RemoteException;;
	

	
}
