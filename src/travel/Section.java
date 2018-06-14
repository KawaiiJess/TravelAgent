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

    protected boolean bookSeatByCols(int[] cols)
    {
        for (int i = 0; i < cols.length; i++)
        {
            for (int j = 0; j < seats[cols[i]].length; j++)
            {
                if (!seats[cols[i]][j].isOccupied())
                {
                    seats[cols[i]][j].fill();
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

    protected final void display()
    {
        String seat = "\t\t" + seatType.toString();
        String seats = getOccupiedSeats();
        System.out.printf("%-15s", seat);
        if (!seats.isEmpty())
        {
            System.out.printf("[%s]", seats);
        }
    }

    private String getOccupiedSeats()
    {
        boolean first = true;
        String returns = "";
        for (int i = 0; i < seats.length; i++)
        {
            for (int j = 0; j < seats[i].length; j++)
            {
                if (seats[i][j].isOccupied())
                {
                    if (first)
                    {
                        first = false;
                    }
                    else
                    {
                        returns += ", ";
                    }

                    returns += seats[i][j].getName();
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

    public static final char seatClassToChar(SeatClass s)
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
