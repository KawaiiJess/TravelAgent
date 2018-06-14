package travel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

public abstract class Trip
{
    private String name;
    private Calendar departure;
    private String source;
    private String dest;

    private Collection<Section> sections;

    protected Trip(String name, String source, String dest, int yr, int mnth, int day, int hr, int min)
    {
        this.departure = validateDate(yr, mnth, day, hr, min);
        if (this.departure == null)
        {
            throw new IllegalArgumentException("Bad Date given to new flight");
        }
        if (source.equals(dest))
        {
            throw new IllegalArgumentException("Same origin and destination");
        }
        this.source = source;
        this.dest = dest;
        this.name = name;
        sections = new ArrayList<>();
    }

    public static Calendar validateDate(int yr, int mnth, int day, int hr, int min)
    {
        Calendar d;
        try
        {
            d = new GregorianCalendar(yr, mnth, day, hr, min);
        }
        catch (Exception e)
        {
            return null;
        }
        Calendar temp = new GregorianCalendar();
        temp.add(Calendar.YEAR, 1);
        if (d.after(temp))
        {
            return null;
        }
        temp.add(Calendar.YEAR, -1);
        if (d.before(temp))
        {
            return null;
        }

        return d;
    }

    protected final boolean addSection(Section s)
    {
        if (s == null)
        {
            return false;
        }
        for (Section st : this.sections)
        {
            if (s.getSeatClass() == st.getSeatClass())
            {
                return false;
            }
        }

        this.sections.add(s);
        return true;
    }

    protected final Collection<Section> getSections()
    {
        return this.sections;
    }

    boolean bookSeat(SeatClass seat, int row, int col)
    {
        for (Section s : sections)
        {
            if (s.getSeatClass() == seat)
            {
                return s.bookSeat(row, col);
            }
        }
        return false;
    }

    protected void display()
    {
        String date = departure.get(Calendar.MONTH) + "/" + departure.get(Calendar.DAY_OF_MONTH) + "/" + departure.get(Calendar.YEAR);
        System.out.printf(" ID: %-8s Source: %-5s Destination: %-5s Departure: %-10s\n", name, source, dest, date);
        for (Section s : sections)
        {
            s.display();
        }
    }

    public final String getSource()
    {
        return this.source;
    }

    public final String getDestination()
    {
        return this.dest;
    }

    public final String getName()
    {
        return this.name;
    }

    public final Calendar getDeparture()
    {
        return this.departure;
    }

    String getAMSmemento(PricingManager pricing)
    {
        return String.format("%s|%s|%s|%s[%s]", this.name, getAMSdeparture(), this.source, this.getDestination(), getAMSsections(pricing));
    }

    private String getAMSdeparture()
    {
        return String.format("%d, %d, %d, %d, %d",
                departure.get(Calendar.YEAR),
                departure.get(Calendar.MONTH),
                departure.get(Calendar.DAY_OF_MONTH),
                departure.get(Calendar.HOUR_OF_DAY),
                departure.get(Calendar.MINUTE));
    }

    private String getAMSsections(PricingManager pricing)
    {
        String returns = "";
        boolean first = true;
        for (Section s : sections)
        {
            if (first)
            {
                first = false;
            }
            else
            {
                returns += ", ";
            }
            double price = pricing.getPricing(source, dest, s.getSeatClass());
            returns += s.getAMSmemento(price);
        }
        return returns;

    }

    public Section getSectionBySeatClass(SeatClass seat)
    {
    	for(Section s: sections)
    		if(s.getSeatClass()==seat)
    			return s;
    	return null;
    }
    
    public abstract boolean equals(Object o);
}
