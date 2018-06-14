package seaTravel;

import java.util.HashMap;

public class CruiseManager {
	private HashMap<String, Seaport> seaports;
    private HashMap<String, CruiseLine> cruiselines;
    
    public CruiseManager()
    {
    	seaports = new HashMap<>();
    	cruiselines = new HashMap<>();
    }
    
    public void createSeaport(String name)
    {
    	try
        {
            if (!seaports.containsKey(name))
            {
                seaports.put(name, new Seaport(name));
                System.out.println("Added seaport " + name);
            }
            else
            {
                System.out.println("That airport already exists!");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Seaport names must be exactly 3 alphanumeric characters!");
        }
    }
    
    public void createCruiseline(String name)
    {
        try
        {
            if (!cruiselines.containsKey(name))
            {
            	cruiselines.put(name, new CruiseLine(name));
                System.out.println("Added cruiseline " + name);
            }
            else
            {
                System.out.println("That cruiseline already exists!");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Cruiseline names must inclusively be between 1 and 6 alphanumeric characters!");
        }
    }
    
    public void createCruise(String cname, String orig, String dest, int year, int month, int day, String id)
    {
        if (cruiselines.containsKey(cname))
        {
            CruiseLine temp = cruiselines.get(cname);
            if (temp.addCruise(id, orig, dest, year, month, day))
            {
                System.out.println("Added cruise " + id + " to cruiseline " + cname);
            }
            else
            {
                System.out.println("Could not add cruise!");
            }

        }
        else
        {
            System.out.println("That cruiseline doesn't exist!");
        }
    }
    
    public void createCabins(String cname, String cID, int numCabins)
    {
        if (cruiselines.containsKey(cname))
        {
            CruiseLine temp = cruiselines.get(cname);
            if (temp.addCabins(cID, numCabins))
            {
                System.out.println("Added cabins to cruise " + cID);
            }
            else
            {
                System.out.println("Could not add cabins!");
            }

        }
        else
        {
            System.out.println("That cruiseline doesn't exist!");
        }

    }
    
    public void findAvailableCruises(String orig, String dest, int...ints) //[Origin, Destination, Year, Month, Day]
    {
        int[] temp = new int[3];
        if (orig == null || dest == null || !cruiselines.containsKey((String) orig) || !seaports.containsKey((String) dest))
        {
            System.out.println("Unknown origin/dest");
            return;
        }

        if (ints.length > 0)
        {
            temp[0] = ints[0];
            temp[1] = ints[1];
            temp[2] = ints[2];
        }
        else
        {
            temp = ints;
        }

        System.out.printf("Cruises from %s to %s\n", orig, dest);
        boolean haveFlight = false;
        for (String airLiner : cruiselines.keySet())
        {
            for (String flight : cruiselines.get(airLiner).getCruise(orig, dest, (int) temp[0], (int) temp[1], (int) temp[2]))
            {
                haveFlight = true;
                System.out.println("\t" + flight);
            }
        }
        if (!haveFlight)
        {
            System.out.println("\tNo Cruises Found");
        }
    }
    
    public void bookCabin(String cruiseline, String cruise, int roomNum)
    {
        if (cruiselines.containsKey(cruiseline))
        {
            CruiseLine temp = cruiselines.get(cruiseline);
            if (temp.bookCabin(cruise, roomNum))
            {
                System.out.println("Booked cabin number " + roomNum + " of cruise " + cruise);
            }
            else
            {
                System.out.println("Could not book cabin!");
            }

        }
        else
        {
            System.out.println("That cuiseline doesn't exist!");
        }
    }
    
    public void displaySystemDetails()
    {
    	for (String cruiseline : cruiselines.keySet())
        {
            cruiselines.get(cruiseline).display();
        }
    }
    
}
