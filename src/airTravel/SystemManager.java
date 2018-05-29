package airTravel;

import airTravel.Airline;
import airTravel.Airport;
import travel.SeatClass;

import java.util.*;

public class SystemManager
{
    private HashMap<String, Airport> airports;
    private HashMap<String, Airline> airlines;

    public SystemManager()
    {
    }

    public void createAirport(String name)
    {
        if (!airports.containsKey(name))
        {
            airports.put(name, new Airport());
        }
        else
        {
            System.out.println("That airport already exists!");
        }
    }

    public void createAirline(String name)
    {
        if (!airlines.containsKey(name))
        {
            airlines.put(name, new Airline(name));
        }
        else
        {
            System.out.println("That airport already exists!");
        }
    }

    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id)
    {
        if (airlines.containsKey(aname))
        {
            Airline temp = airlines.get(aname);
            if (!temp.addFlight(id, orig, dest, year, month, day))
            {
                System.out.println("Could not add flight!");
            }
        }
        else
        {
            System.out.println("That airline doesn't exist!");
        }
    }

    public void createSection(String air, String flID, int rows, int cols, SeatClass s)
    {

    }

    public void findAvailableFlights(String orig, String dest)
    {
        //We're going to use an iterator to print directly to terminal.
    }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col)
    {

    }

    public void displaySystemDetails()
    {

    }
}
