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
    	return castObjectToStringArray(selectedTrips.toArray());
    }

    private String[] castObjectToStringArray(Object[] ara) 
    {
    	String[] s = new String[ara.length];
    	for(int i = 0; i < ara.length; i++) 
    		s[i] = (String) ara[i];
    	return s;
    	
    }
    
    protected final boolean addSection(String trip, Section s) 
    {
    	if(trip == null || s == null)
    		return false;
    	Trip t = null;
    	for(Trip st: trips)
    	{
    		if(st.getName().equals(trip))
    			t = st;
    	}
    	if(t == null)
    		return false;
    	return t.addSection(s);
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
