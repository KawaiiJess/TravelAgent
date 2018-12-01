package airTravel;

import travel.Hub;

public class Airport extends Hub
{
    Airport(String name) throws IllegalArgumentException
    {
        super(name);
    }

    public void display()
    {
        System.out.println("Airport: " + super.getName());
    }

    protected String getAMSmemento()
    {
        return super.getName();
    }
}
