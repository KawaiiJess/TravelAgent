package seaTravel;

import travel.Hub;

public class Seaport extends Hub
{
    Seaport(String name) throws IllegalArgumentException
    {
        super(name);
    }

    public void display()
    {
        System.out.println("Seaport: " + super.getName());
    }

    protected String getAMSmemento()
    {
        return super.getName();
    }
}