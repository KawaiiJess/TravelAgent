package airTravel;

import travel.SeatClass;
import travel.Section;

public class FlightSection extends Section
{
    FlightSection(SeatClass seatClass, int rows, int cols) throws IllegalArgumentException
    {
        super(seatClass, rows, cols,'N');
        if (rows > 100 || cols > 10)
        {
            throw new IllegalArgumentException("to many rows or cols passed to new FlightSection");
        }
    }

    FlightSection(SeatClass seatClass, int rows, char layout)
    {
        super(seatClass, rows, getNumCols(layout), layout);
    }

    private static int getNumCols(char layoutCode)
    {
        if (layoutCode == 'S')
        {
            return 3;
        }
        if (layoutCode == 'M')
        {
            return 4;
        }
        return 10;
    }

    boolean bookSeat(char c, int i)
    {
        return super.bookSeat(c, i);
    }
}
