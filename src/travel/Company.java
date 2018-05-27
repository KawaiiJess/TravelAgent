package travel;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Company
{
    private Collection<Trip> trips;
    private String name;

    public Company(String name)
    {
    	this.name = name;
    	this.trips = new ArrayList<Trip>();
    }

    public final String getName()
    {
        return this.name;
    }

    public abstract void display();


    public final String[] getTrips(String src, String dest)
    {
    	return null;
    }

    public final boolean addTrip(String compName, String src, String dest, int year, int month, int day, String id) {
    	return false;
    }
}
