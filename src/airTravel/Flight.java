package airTravel;


import java.util.Calendar;
import java.util.GregorianCalendar;

import travel.SeatClass;
import travel.Trip;

public class Flight implements Trip
{
	private String name;
	private Calendar departure;
	private String source;
	private String dest;
	
	public Flight(String name, String source, String dest, int yr, int mnth, int day) {
		this.departure = validateDate(yr,mnth,day);
		if(this.departure == null)
			throw new IllegalArgumentException("Bad Date given to new flight");
		this.source = source;
		this.dest = dest;
		this.name = name;
	}
	
	private static Calendar validateDate(int yr, int mnth, int day)
	{
		Calendar d;
		try {
			d = new GregorianCalendar(yr,mnth,day);
		}catch(Exception e) {
			return null;
		}
		Calendar temp = new GregorianCalendar();
		temp.add(Calendar.YEAR, 1);
		if(d.after(temp))
			return null;
		temp.add(Calendar.YEAR, -7);
		if(d.before(temp))
			return null;
		
		return d;
	}
	
	public String getName() 
	{
		return this.name;
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
			return (that.departure.equals(this.departure) &&
					that.name.equals(this.name) &&
					that.getSource().equals(this.getSource()) &&
					that.getDestination().equals(this.getDestination()));
		}
		return false;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSource() {
		return this.source;
	}

	@Override
	public String getDestination() {
		return this.dest;
	}

	public SeatClass getSeatClass() {
		return seatClass;
	}
}
