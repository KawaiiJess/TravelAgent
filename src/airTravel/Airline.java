package airTravel;
import travel.*;

class Airline extends Company
{
    Airline(String name) throws IllegalArgumentException
    {
        super(validateName(name));
    }

    private static String validateName(String name)
    {
        String nameUpper = name.toUpperCase();
        if (nameUpper.length() < 7 && nameUpper.length() > 0)
        {
            char[] chars = nameUpper.toCharArray();
            for (char c : chars)
            {
                if (!Character.isLetterOrDigit(c))
                {
                    throw new IllegalArgumentException();
                }
            }
            return nameUpper;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    protected void display()
    {
        System.out.println("I am airline: " + super.getName());
    }
    
    String[] getFlight(String orig, String dest)
    {
        return super.getTrips(orig, dest);
    }

    boolean addFlight(String name, String source, String dest, int year, int month, int day)
    {
    	try {
    		Trip t = new Flight(name, source, dest, year, month, day);
    		super.addTrip(t);
    	}catch(Exception e) {
    		return false;
    	}
    	
    	return true;
    }
}