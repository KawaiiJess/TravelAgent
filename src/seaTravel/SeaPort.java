package seaTravel;

import travel.Hub;

public class SeaPort extends Hub
{
    private String name;

    SeaPort(String name) throws IllegalArgumentException
    {
        String nameUpper = name.toUpperCase();

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

    public String getName()
    {
        return this.name;
    }

    public void display()
    {
        System.out.println("SeaPort: " + this.name);
    }

    protected String getAMSmemento()
    {
        return this.name;
    }
}
