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
	
	protected Trip(String name, String source, String dest, int yr, int mnth, int day) 
	{
		this.departure = validateDate(yr,mnth,day);
		if(this.departure == null)
			throw new IllegalArgumentException("Bad Date given to new flight");
		this.source = source;
		this.dest = dest;
		this.name = name;
		sections = new ArrayList<>();
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
	
	protected final boolean addSection(Section s) 
	{
		if(s == null)
			return false;
		for(Section st : this.sections)
			if(s.getSeatClass() == st.getSeatClass())
				return false;

		this.sections.add(s);
		return true;
	}
	
	protected final Collection<Section> getSections()
	{
		return this.sections;
	}
	
	public abstract void display();
	
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
	
	public abstract boolean equals(Object o);
}
