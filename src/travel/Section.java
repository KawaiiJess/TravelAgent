package travel;

public abstract class Section
{
    private Seat[][] seats;
    private SeatClass seatType;
    private char layoutCode;

    protected Section(SeatClass seatType, int numRows, int numCols, char layoutCode)
    {
        if (seatType == null || numRows <= 0 || numCols <= 0)
        {
            throw new IllegalArgumentException("Bad name, class, numRows, or numCols passed to new Section()");
        }

        this.layoutCode = layoutCode;

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
        for (Seat[] seat : seats)
        {
            for (Seat aSeat : seat)
            {
                if (!aSeat.isOccupied())
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean bookSeat()
    {
        for (Seat[] seat : seats)
        {
            for (Seat aSeat : seat)
            {
                if (!aSeat.isOccupied())
                {
                    aSeat.fill();
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean bookSeatByCols(int[] cols)
    {
        for (int col : cols)
        {
            for (Seat[] seat : seats)
            {
                if (!seat[col].isOccupied())
                {
                    seat[col].fill();
                    return true;
                }
            }
        }
        return bookSeat();
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

    protected final void display(double price)
    {
        String seat = "\t\t" + seatType.toString();
        String seats = getOccupiedSeats();
        System.out.printf("%-15s$%-10.2f", seat,price);
        if (!seats.isEmpty())
        {
            System.out.printf("[%s]", seats);
        }
    }

    private String getOccupiedSeats()
    {
        boolean first = true;
        String returns = "";
        for (Seat[] seat : seats)
        {
            for (Seat aSeat : seat)
            {
                if (aSeat.isOccupied())
                {
                    if (first)
                    {
                        first = false;
                    }
                    else
                    {
                        returns += ", ";
                    }

                    returns += aSeat.getName();
                }
            }
        }
        return returns;
    }

    protected final SeatClass getSeatClass()
    {
        return this.seatType;
    }

    String getAMSmemento(double price)
    {
        return String.format("%c:%.2f:%c:%d", seatClassToChar(seatType), price, layoutCode, seats.length);
    }

    private static char seatClassToChar(SeatClass s)
    {
        if (s == SeatClass.first)
        {
            return 'F';
        }
        if (s == SeatClass.business)
        {
            return 'B';
        }

        return 'E';
    }
}
