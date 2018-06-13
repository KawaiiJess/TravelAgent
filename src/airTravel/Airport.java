package airTravel;

import travel.Hub;

public class Airport extends Hub
{
    private String name;

    Airport(String name)
    {
        if (Hub.validateName(name))
        {
            this.name = name;
        }
    }

    public String getName()
    {
        return this.name;
    }

    public void display()
    {
        System.out.println("Airport: " + this.name);
    }
    
    protected String getAMSMemento()
    {
    	return this.name;
    }
}
