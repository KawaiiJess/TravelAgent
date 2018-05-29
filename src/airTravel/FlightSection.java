package airTravel;

import travel.SeatClass;
import travel.Section;

public class FlightSection extends Section
{
    FlightSection(SeatClass seatClass, int rows, int cols) throws IllegalArgumentException
    {
        super(seatClass,rows, cols);
        
        if(rows > 100 || cols > 10)
        	throw new IllegalArgumentException("to many rows or cols passed to new FlightSection");
    }

    
    
    boolean bookSeat(char c, int i)
    {
        return super.bookSeat(c, i);
    }

    protected void display()
    {
        System.out.println("My flight ID is:");
    }
}
