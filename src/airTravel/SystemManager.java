package airTravel;

import travel.SeatClass;

import java.util.HashMap;

public class SystemManager
{
    private HashMap<String, Airport> airports;
    private HashMap<String, Airline> airlines;

    public SystemManager()
    {
        airports = new HashMap<>();
        airlines = new HashMap<>();
    }

    public void createAirport(String name)
    {
        if (name == null)
        {
            System.out.println("Null is not a valid airport name!");
        }
        else
        {
            try
            {
                if (!airports.containsKey(name))
                {
                    airports.put(name, new Airport(name));
                    System.out.println("Added airport " + name);
                }
                else
                {
                    System.out.println("That airport already exists!");
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Airport names must be exactly 3 alphanumeric characters!");
            }
        }
    }

    public void createAirline(String name)
    {
        if (name == null)
        {
            System.out.println("Null is not a valid airline name!");
        }
        else
        {
            try
            {
                if (!airlines.containsKey(name))
                {
                    airlines.put(name, new Airline(name));
                    System.out.println("Added airline " + name);
                }
                else
                {
                    System.out.println("That airport already exists!");
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Airline names must inclusively be between 1 and 6 alphanumeric characters!");
            }
        }
    }

    public void createFlight(String aname, String orig, String dest, int year, int month, int day, String id)
    {
        if (airlines.containsKey(aname))
        {
            Airline temp = airlines.get(aname);
            if (temp.addFlight(id, orig, dest, year, month, day))
            {
                System.out.println("Added flight " + id + " to airline " + aname);
            }
            else
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
        if (s == null)
        {
            System.out.println("Null is not a valid seat class!");
        }
        else
        {
            if (airlines.containsKey(air))
            {
                Airline temp = airlines.get(air);
                if (temp.createFlightSection(flID, s, rows, cols))
                {
                    System.out.println("Added section to flight " + flID);
                }
                else
                {
                    System.out.println("Could not add flight section!");
                }

            }
            else
            {
                System.out.println("That airline doesn't exist!");
            }
        }
    }

    public void findAvailableFlights(String orig, String dest)
    {
        if (orig == null || dest == null || !airports.containsKey(orig) || !airports.containsKey(dest))
        {
            System.out.println("Unknown origin/dest");
            return;
        }

        System.out.printf("Flights from %s to %s\n", orig, dest);
        boolean haveFlight = false;
        for (String airLiner : airlines.keySet())
        {
            for (String flight : airlines.get(airLiner).getFlight(orig, dest))
            {
                haveFlight = true;
                System.out.println("\t" + flight);
            }
        }
        if (!haveFlight)
        {
            System.out.println("\tNo Flights Found");
        }
    }

    public void bookSeat(String air, String fl, SeatClass s, int row, char col)
    {
        if (row == 0 || col == 0)
        {
            System.out.println("Null is not a valid seat position!");
        }
        else
        {
            if (airlines.containsKey(air))
            {
                Airline temp = airlines.get(air);
                if (temp.bookSeat(fl, s, row, col))
                {
                    System.out.println("Booked seat " + row + col + " of flight " + fl);
                }
                else
                {
                    System.out.println("Could not book seat!");
                }

            }
            else
            {
                System.out.println("That airline doesn't exist!");
            }
        }
    }

    public void displaySystemDetails()
    {
        for (String airLiner : airlines.keySet())
        {
            airlines.get(airLiner).display();
        }
    }

    public void addAirports(Airport[] airports)
    {
        for (Airport h : airports)
        {
            this.airports.put(h.getName(), h);
        }
    }

    public void addAirlines(Airline[] airlines)
    {
        for (Airline a : airlines)
        {
            this.airlines.put(a.getName(), a);
        }
    }
}
