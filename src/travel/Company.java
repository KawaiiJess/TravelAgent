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
    	this.trips = new ArrayList<Trip>();
    }

    protected final String getName()
    {
        return this.name;
    }

    protected abstract void display();

    protected final String[] getTrips(String src, String dest)
    {
    	Collection<String> selectedTrips = new ArrayList<>();
    	for(Trip t : this.trips) 
    	{
    		if(t.getSource().equals(src) && t.getDestination().equals(dest))
    			selectedTrips.add(t.getName());
    	}
    	return (String[]) selectedTrips.toArray();
    }

    protected final boolean addTrip(Trip t) 
    {
    	for(Trip h: trips)
    	{
    		if(t.equals(h))
    			return false;
    	}
    	this.trips.add(t);
    	return true;
    }
}
