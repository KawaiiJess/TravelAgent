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
        if (nameUpper.length() < 7)
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

    public void display()
    {
        System.out.println("I am airline: " + super.getName());
    }

    public String[] getFlight(String orig, String dest)
    {
        return new String[0];
    }

    public boolean addFlight(String a, int i, int j, int k, SeatClass asdf)
    {
        return true;
    }
}