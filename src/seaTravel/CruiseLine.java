package seaTravel;

import travel.Company;
import travel.SeatClass;
import travel.Section;
import travel.Trip;

public class CruiseLine extends Company
{

    protected CruiseLine(String name)
    {
        super(name);
    }

    boolean addCabins(String cruise, int numCabins)
    {
        Section s;
        try
        {
            s = new Cabins(numCabins);
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
        return super.addSection(cruise, s);
    }

    boolean addCruise(Trip t)
    {
        return super.addTrip(t);
    }

    boolean addCruiseSection(String cruise, Section section)
    {
        return super.addSection(cruise, section);
    }

    protected void display()
    {
        System.out.println("Cruise: " + super.getName());
        super.display();
    }

    String[] getCruise(String orig, String dest)
    {
        return super.getTrips(orig, dest);
    }

    String[] getCruise(String orig, String dest, int year, int month, int day)
    {
        return super.getTrips(orig, dest, year, month, day);
    }

    boolean addCruise(String name, String source, String dest, int year, int month, int day)
    {
        if (name == null)
        {
            return false;
        }
        try
        {
            Trip t = new Cruise(name, source, dest, year, month, day);
            super.addTrip(t);
            return true;
        }
        catch (Exception ignore)
        {
        }
        return false;
    }

    boolean bookCabin(String cruiseID, int roomNumber)
    {
        return super.bookSeat(cruiseID, SeatClass.economy, roomNumber, 0);
    }

}
