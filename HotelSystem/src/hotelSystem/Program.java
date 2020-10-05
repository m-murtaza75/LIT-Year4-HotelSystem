package hotelSystem;

public class Program 
{

	@SuppressWarnings("unused")
	public static void main(String[] args) throws NoSuchBookingException 
	{
		// TODO Auto-generated method stub
				
		System.out.println("\t*** WELCOME TO HOTEL SYSTEM ***\n");
		
		int[] roomNumbers = {4, 6, 8, 10, 12, 15};
		
		Hotel hotel = new Hotel(roomNumbers);
		
		Integer[] days1 = {6, 5, 8, 9, 3, 4};
		Integer[] days2 = {7, 10, 18, 9, 13, 5};
		Integer[] days3 = {7, 10, 18, 21, 13, 5};
		Integer[] days4 = {13, 15, 16, 19, 18};
		Integer[] days5 = {23, 25, 26, 28, 29};
		Integer[] days6 = {1, 2, 21, 22, 29};
						
		String ref1 = "ref1";
		String ref2 = "ref2";
		String ref3 = "bref3room4";
		String ref4 = "bookingRef4";
		String ref5 = "br4612";
		
		int room4 = 4;
		int[] roomsToAdd = {8, 10, 12};
		int[] roomsToUpdate = {8, 10, 12};
		int[] roomsToBook = {4, 6, 12};
		
		boolean result = hotel.roomBooked(days1, room4);
		
		System.out.println("Room " + room4 + " is booked on days1 Result: " + result);
		System.out.println("Expected Result: false\n");
		
		if (!result) // false means there was no booked room for given days & room number.
        {
            boolean bookingResult = hotel.bookRoom(ref1, days1, room4);
            
            System.out.println("Booking Result for room " + room4 + " on ref: " + ref1 + "\nResult: " + bookingResult);
            System.out.println("Expected Result: true");
        }
		
		// Should be false
		boolean bookingResult2 = hotel.bookRoom(ref2, days1, room4);
		System.out.println("\nBooking result for room " + room4 + " on ref: " + ref2 + " \nResult: " + bookingResult2);
		System.out.println("Expected Result: false (Already booked)\n");
		
		
		boolean result2 = hotel.roomBooked(days2, room4);
		
		System.out.println("\nRoom " + room4 + " is booked on days2 Result: " + result2);
		System.out.println("Expected Result: true\n");				
					
		boolean updateResult = hotel.updateBooking(ref1, days3, room4);			
		System.out.println("\nUpdating Booking of Room " + room4 + " for ref: " + ref1 + "\nResult: " + updateResult);
		System.out.println("Expected Result: true\n");
		
		hotel.cancelBooking(ref1);				
		
		boolean addNewBookingResult = hotel.bookRooms(ref3, days4, roomsToAdd);			
		System.out.println("New Booking for adding multiple Rooms on ref: " + ref3 + "\nResult: " + addNewBookingResult);
		System.out.println("Expected Result: true\n");				
		
		// Should give exception as this bookingRef doesn't exists
		try
		{
			boolean updateRoomsResult= hotel.updateBooking(ref4, days5, roomsToUpdate);
		}
		catch(NoSuchBookingException e)
		{
			e.printStackTrace();
		}
		
		boolean bookRoomResult = hotel.bookRoom(ref2, days3, room4);
		System.out.println("\nBooking Room " + room4 + " for ref: " + ref2 + "\nResult: " + bookRoomResult);
		System.out.println("Expected Result: true\n");
		
		
		boolean newBooking = hotel.bookRooms(ref5, days6, roomsToBook);
		System.out.println("New Booking for adding multiple Rooms on ref: " + ref5 + "\nResult: " + newBooking);
		System.out.println("Expected Result: false\n");
				
	}
}