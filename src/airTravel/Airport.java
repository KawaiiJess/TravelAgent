package airTravel;
import travel.*;

public class Airport implements Hub
{
    private String name;

    Airport(String name) throws IllegalArgumentException
    {
        String nameUpper = name.toUpperCase();
        if (nameUpper.length() == 3)
        {
            char[] chars = nameUpper.toCharArray();
            for (char c : chars)
            {
                if (!Character.isLetter(c))
                {
                    throw new IllegalArgumentException();
                }
            }
            this.name = nameUpper;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public String getName()
    {
        return this.name;
    }

    public void display()
    {
        System.out.println("My airport code is: " + this.name);
    }
}
