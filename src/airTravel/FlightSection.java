package airTravel;

import travel.SeatClass;
import travel.Section;

public class FlightSection extends Section
{
	private int[] aisles;
	private int[] windows;
	
    FlightSection(SeatClass seatClass, int rows, int cols) throws IllegalArgumentException
    {
        super(seatClass, rows, cols, 'N');
        if (rows > 100 || cols > 10)
        {
            throw new IllegalArgumentException("to many rows or cols passed to new FlightSection");
        }
    }

    FlightSection(SeatClass seatClass, int rows, char layout)
    {
        super(seatClass, rows, getNumCols(layout), layout);
        if(layout=='S') {
        	aisles = new int[]{0,1};
        	windows = new int[] {0,2};
        }
        else if(layout == 'M') {
        	aisles = new int[] {1,2};
        	windows = new int[] {0,3};
        }
        else if(layout == 'W') {
        	aisles = new int[] {2,3,6,7};
        	windows = new int[] {0,9};
        }
    }

    private static int getNumCols(char layoutCode)
    {
        if (layoutCode == 'S')
            return 3;
        if (layoutCode == 'M')
            return 4;
        return 10;
    }

    boolean bookSeat(char c, int i)
    {
        return super.bookSeat(c, i);
    }
    
    boolean bookSeat(boolean windowSeat, boolean aisleSeat)
    {
    	if(windowSeat && !aisleSeat)
    		return bookSeatByCols(windows);
    	else if(!windowSeat && aisleSeat)
    		return bookSeatByCols(aisles);
    	return false;
    }
}
