package airTravel;

import travel.Trip;

public class Flight extends Trip
{
	Flight(String name, String source, String dest, int yr, int mnth, int day, int hr, int min)
	{
		super(name,source,dest,yr,mnth,day,hr,min);
	}
    Flight(String name, String source, String dest, int yr, int mnth, int day)
    {
        this(name,source,dest,yr,mnth,day,0,0);
    }

    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (o == this)
        {
            return true;
        }
        if (o instanceof Flight)
        {
            Flight that = (Flight) o;
            return (that.getDeparture().equals(this.getDeparture()) &&
                    that.getName().equals(this.getName()) &&
                    that.getSource().equals(this.getSource()) &&
                    that.getDestination().equals(this.getDestination()));
        }
        return false;
    }

    @Override
	protected void display()
    {
        System.out.print("\tFlight =");
        super.display();
    }
}
