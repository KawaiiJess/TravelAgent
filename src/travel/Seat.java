package travel;

public class Seat
{
    private String name;
    private boolean occupied;

    Seat(String name)
    {
        this.name = name;
        this.occupied = false;
    }

    Seat(int row, int col)
    {
        this(convertName(row, col));
    }

    private static String convertName(int row, int col)
    {
        return Integer.toString(row) + (char) (col + 65);
    }

    public void fill()
    {
        this.occupied = true;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean isOccupied()
    {
        return this.occupied;
    }
}
