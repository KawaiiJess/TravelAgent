package airTravel;

import travel.Trip;

public class Flight extends Trip
{	
	Flight(String name, String source, String dest, int yr, int mnth, int day) 
	{
		super(name, source, dest, yr, mnth, day);
	}
	
	public boolean equals(Object o) 
	{
		if(o == null)
			return false;
		if(o == this)
			return true;
		if(o instanceof Flight) 
		{
			Flight that = (Flight)o;
			return (that.getDeparture().equals(this.getDeparture()) &&
					that.getName().equals(this.getName()) &&
					that.getSource().equals(this.getSource()) &&
					that.getDestination().equals(this.getDestination()));
		}
		return false;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
