package airTravel;

import travel.Company;
import travel.SeatClass;
import travel.Section;
import travel.Trip;

class Airline extends Company
{
    Airline(String name) throws IllegalArgumentException
    {
        super(name);
    }

    boolean createFlightSection(String flight, SeatClass seatClass, int rows, int cols)
    {
        Section s;
        try
        {
            s = new FlightSection(seatClass, rows, cols);
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }

        return super.addSection(flight, s);
    }

    boolean addFlight(Trip t)
    {
        return super.addTrip(t);
    }

    boolean addFlightSection(String flight, Section section)
    {
        return super.addSection(flight, section);
    }

    protected void display()
    {
        System.out.println("Airline: " + super.getName());
        super.display();
    }

    String[] getFlight(String orig, String dest)
    {
        return super.getTrips(orig, dest);
    }

    String[] getFlight(String orig, String dest, int year, int month, int day)
    {
        return super.getTrips(orig, dest, year, month, day);
    }

    boolean addFlight(String name, String source, String dest, int year, int month, int day)
    {
        if (name == null)
        {
            System.out.println("Null is not a valid flight ID!");
            return false;
        }
        else
        {
            try
            {
                Trip t = new Flight(name, source, dest, year, month, day);
                super.addTrip(t);
            }
            catch (Exception e)
            {
                return false;
            }

            return true;
        }
    }

    boolean bookSeat(String fID, SeatClass s, int row, char col)
    {
        char colUpper = Character.toUpperCase(col);
        int colInt = ((int) colUpper) - 65;
        if (colInt < 0 || colInt > 9)
        {
            System.out.println("Seat index out of range.");
            return false;
        }
        else
        {
            return super.bookSeat(fID, s, row, colInt);
        }
    }

    //shhh, you don't see anything
    boolean bookSeat(String fID, SeatClass seat, boolean windowSeat, boolean aisleSeat)
    {
        Trip t = getTripByName(fID);
        if (t == null)
        {
            return false;
        }
        Section s = t.getSectionBySeatClass(seat);
        FlightSection section = (FlightSection) s;
        return section.bookSeat(windowSeat, aisleSeat);
    }
}