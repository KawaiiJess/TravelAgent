package travel;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Company
{
    private Collection<Trip> trips;
    private String name;

    protected Company(String name)
    {
        this.name = name;
        this.trips = new ArrayList<>();
    }

    protected final String getName()
    {
        return this.name;
    }

    protected void display()
    {
        if (trips.isEmpty())
        {
            System.out.println("\tEmpty");
        }
        else
        {
            for (Trip t : trips)
            {
                t.display();
            }
        }
    }

    protected boolean bookSeat(String trip, SeatClass seat, int row, int col)
    {
        Trip t = getTripFromName(trip);
        if (t == null)
        {
            return false;
        }
        return t.bookSeat(seat, row, col);
    }

    protected final String[] getTrips(String src, String dest)
    {
        Collection<String> selectedTrips = new ArrayList<>();
        for (Trip t : this.trips)
        {
            if (t.getSource().equals(src) && t.getDestination().equals(dest))
            {
                selectedTrips.add(t.getName());
            }
        }
        return castObjectToStringArray(selectedTrips.toArray());
    }

    private String[] castObjectToStringArray(Object[] ara)
    {
        String[] s = new String[ara.length];
        for (int i = 0; i < ara.length; i++)
        {
            s[i] = (String) ara[i];
        }
        return s;

    }

    protected final boolean addSection(String trip, Section s)
    {
        if (trip == null || s == null)
        {
            return false;
        }
        Trip t = getTripFromName(trip);
        if (t == null)
        {
            return false;
        }
        return t.addSection(s);
    }

    protected final boolean addTrip(Trip t)
    {

        this.trips.add(t);
        return true;
    }

    private Trip getTripFromName(String name)
    {
        for (Trip h : trips)
        {
            if (h.getName().equals(name))
            {
                return h;
            }
        }
        return null;
    }
}