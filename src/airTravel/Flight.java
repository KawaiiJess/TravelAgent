package airTravel;

import travel.SeatClass;
import travel.Section;
import travel.Trip;

public class Flight extends Trip
{	
	Flight(String name, String source, String dest, int yr, int mnth, int day) 
	{
		super(name, source, dest, yr, mnth, day);
	}

	
	boolean createSection(SeatClass seatClass, int rows, int cols) {
		Section s;
		try 
		{
			s = new FlightSection(seatClass, rows,cols);
		}
		catch(IllegalArgumentException e)
		{
			return false;
		}
		
		return super.addSection(s);
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
