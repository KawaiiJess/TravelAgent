package seaTravel;

import travel.Trip;

public class Cruise extends Trip
{

    Cruise(String name, String source, String dest, int yr, int mnth, int day, int hr, int min)
    {
        super(name, source, dest, yr, mnth, day, hr, min);
    }

    Cruise(String name, String source, String dest, int yr, int mnth, int day)
    {
        this(name, source, dest, yr, mnth, day, 0, 0);
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
        if (o instanceof Cruise)
        {
            Cruise that = (Cruise) o;
            return (that.getDeparture().equals(this.getDeparture()) &&
                    that.getName().equals(this.getName()) &&
                    that.getSource().equals(this.getSource()) &&
                    that.getDestination().equals(this.getDestination()));
        }
        return false;
    }
}
