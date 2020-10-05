package hotelSystem;


@SuppressWarnings("serial")
public class NoSuchBookingException extends Exception {
	
	public NoSuchBookingException (String bookingRef) {		
		super("There can be no booking with reference " + bookingRef);
	}
}