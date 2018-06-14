package travel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

public abstract class Company
{
    private Collection<Trip> trips;
    private String name;
    private PricingManager pricingManager;

    protected Company(String name)
    {
        if (validateName(name))
        {
            this.name = name.toUpperCase();
        }
        this.trips = new ArrayList<>();
        this.pricingManager = new PricingManager();
    }

    public final String getName()
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
                t.display(pricingManager);
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

    protected final String[] getTrips(String src, String dest, int year, int month, int day)
    {
        Calendar departure = new GregorianCalendar(year, month, day);
        Collection<String> selectedTrips = new ArrayList<>();
        for (Trip t : this.trips)
        {
            Calendar c = t.getDeparture();
            if (t.getSource().equals(src) && t.getDestination().equals(dest) && isSameDay(departure, c))
            {
                selectedTrips.add(t.getName());
            }
        }
        return castObjectToStringArray(selectedTrips.toArray());
    }

    private static boolean isSameDay(Calendar cal1, Calendar cal2)
    {
        if (cal1 == null || cal2 == null)
        {
            throw new IllegalArgumentException("The date must not be null");
        }

        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
                && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1
                .get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
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

    public static boolean validateName(String name) throws IllegalArgumentException
    {
        String nameUpper = name.toUpperCase();
        if (nameUpper.length() < 7 && nameUpper.length() > 0)
        {
            char[] chars = nameUpper.toCharArray();
            for (char c : chars)
            {
                if (!Character.isLetterOrDigit(c))
                {
                    throw new IllegalArgumentException();
                }
            }
            return true;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public final double getPricing(String orig, String dest, SeatClass seatClass)
    {
        return this.pricingManager.getPricing(orig, dest, seatClass);
    }

    public final boolean setPricing(String orig, String dest, SeatClass seatClass, double price)
    {
        try
        {
            this.pricingManager.setPricing(orig, dest, seatClass, price);
            return true;
        }
        catch (IllegalArgumentException ignored)
        {
        }
        return false;
    }

    public final String getAMSmemento()
    {
        return String.format("%s[%s]", this.name, getFlightAMS());
    }

    private String getFlightAMS()
    {
        boolean first = true;
        String returns = "";
        for (Trip t : trips)
        {
            if (first)
            {
                first = false;
            }
            else
            {
                returns += ",";
            }
            returns += t.getAMSmemento(pricingManager);
        }
        return returns;
    }

    protected Trip getTripByName(String name)
    {
        for (Trip t : trips)
        {
            if (t.getName().equals(name))
            {
                return t;
            }
        }
        return null;
    }
}