package travel;

public abstract class Section
{
    private Seat[][] seats;
    private SeatClass seatType;

    protected Section(SeatClass seatType, int numRows, int numCols)
    {
        if (seatType == null || numRows <= 0 || numCols <= 0)
        {
            throw new IllegalArgumentException("Bad name, class, numRows, or numCols passed to new Section()");
        }

        seats = new Seat[numRows][];
        for (int i = 0; i < numRows; i++)
        {
            seats[i] = new Seat[numCols];
            for (int j = 0; j < numCols; j++)
            {
                seats[i][j] = new Seat(i, j);
            }
        }
        this.seatType = seatType;
    }

    protected final boolean hasAvailableSeat()
    {
        for (int i = 0; i < seats.length; i++)
        {
            for (int j = 0; j < seats[i].length; j++)
            {
                if (!seats[i][j].isOccupied())
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean bookSeat()
    {
        for (int i = 0; i < seats.length; i++)
        {
            for (int j = 0; j < seats[i].length; j++)
            {
                if (!seats[i][j].isOccupied())
                {
                    seats[i][j].fill();
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean bookSeat(int row, int col)
    {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[row].length)
        {
            return false;
        }
        if (!seats[row][col].isOccupied())
        {
            seats[row][col].fill();
            return true;
        }
        return false;

    }

    protected void display()
    {
        System.out.print("[");
        for (int i = 0; i < seats.length; i++)
        {
            for (int j = 0; j < seats[i].length; j++)
            {
                if ((i == seats.length - 1) && (j == seats[i].length - 1))
                {
                    System.out.println(seats[i][j].getName() + "]");
                }
                else if (seats[i][j].isOccupied())
                {
                    System.out.println(seats[i][j].getName() + ", ");
                }
            }
        }
    }

    protected final SeatClass getSeatClass()
    {
        return this.seatType;
    }
}
