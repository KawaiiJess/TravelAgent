package airTravel;

import travel.Section;

public class FlightSection extends Section
{
    FlightSection()
    {
        super();
    }

    protected boolean bookSeat(char c, int i)
    {
        return super.bookSeat(c, i);
    }

    protected void display()
    {
        System.out.println("My flight ID is: " + super.getName());
    }
}
