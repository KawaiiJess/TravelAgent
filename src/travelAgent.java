import airTravel.AirportFactory;
import airTravel.SystemManager;
import travel.Hub;
import travel.Trip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class travelAgent
{
    private static Scanner user = new Scanner(System.in);
    private static SystemManager airSysMgr;
    private static SystemManager seaSysMgr;
    private static SystemManager trainSysMgr;

    private static void displayMenu()
    {
        System.out.println("===================Travel Agent===================");
        System.out.println(" 1: Generate system using an AMS file.");
        System.out.println(" 2: Generate system manually.");
        System.out.println(" 3: Query available trips.");
        System.out.println(" 4: Change seat price.");
        System.out.println(" 5: Book a seat.");
        System.out.println(" 6: Display system.");
        System.out.println(" 7: Delete system.");
        System.out.println(" 8: Serialize airport system into an AMS file.");
        System.out.println("-1: Close Travel Agent.");
        System.out.println("=================Make a Selection=================");
    }

    public static void main(String[] args)
    {
        displayMenu();
        int choice = intParam();
        while (choice > 0)
        {
            switch (choice)
            {
                case 1:
                    loadAMS();
                    break;
                case 2:
                    generateManually();
                    break;
                case 3:
                    queryAvailable();
                    break;
                case 4:
                    changePricing();
                    break;
                case 5:
                    bookSeat();
                    break;
                case 6:
                    displaySystem();
                    break;
                case 7:
                    deleteSystem();
                    break;
                case 8:
                    saveAMS();
                    break;
                default:
                    loadAMS();
            }
            System.out.print("\n\n");
            displayMenu();
            choice = intParam();
        }
        user.close();
    }

    private static int intParam()
    {
        while (!user.hasNextInt())
        {
            user.next();
            System.out.println("Integers only please.");
        }
        return user.nextInt();
    }

    private static String travelMethod()
    {
        System.out.println("Airplane 'A' or Cruise 'C'?");
        while (!user.next().equals("A") || !user.next().equals("C"))
        {
            user.next();
            System.out.println("'A' or 'C' only please.");
        }
        return user.next();
    }

    private static String getFile() throws IOException
    {
        System.out.print("Enter the name of your AMS file without extension: ");
        File file = new File(user.next() + ".ams");
        if (file.exists() && file.isFile())
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br.readLine();
        }
        return "";
    }

    private static char determineTravelType(String AMS)
    {
        return AMS.toUpperCase().charAt(0);
    }

    private static ArrayList<Object> getQueryInfo()
    {
        ArrayList<Object> query = new ArrayList<>();
        boolean origValid = false;
        while (!origValid)
        {
            System.out.println("Origin?: ");
            String orig = user.next();
            origValid = Hub.validateName(orig);
            if (origValid)
            {
                query.add(orig);
            }
        }

        boolean destValid = false;
        while (!destValid)
        {
            System.out.println("Destination?: ");
            String dest = user.next();
            destValid = Hub.validateName(dest);
            if (destValid)
            {
                query.add(dest);
            }
        }

        Calendar dateValid = null;
        while (dateValid == null)
        {
            System.out.println("Date? [year, month, day]: ");
            int year = intParam();
            int month = intParam();
            int day = intParam();
            dateValid = Trip.validateDate(year, month, day, 0, 0);
            if (dateValid != null)
            {
                query.add(year);
                query.add(month);
                query.add(day);
            }
        }
        return query;
    }

    private static void loadAMS()
    {
        System.out.println(" 1: Generate airport system using AMS file.");
        try
        {
            String AMS = getFile();
            char type = determineTravelType(AMS);
            if (!AMS.equals(""))
            {
                AirportFactory f = new AirportFactory();
                airSysMgr = f.buildAirportSystem(AMS, type);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void generateManually()
    {
        System.out.println(" 2: Generate system manually.");
    }

    private static void queryAvailable()
    {
        char type = travelMethod().toUpperCase().charAt(0);
        if (type == 'C')
        {
            //seaSysMgr.findAvailableCabins();
        }
        else if (type == 'T')
        {
            //trainSysMgr.findAvailableTrains();
        }
        else
        {
            //airSysMgr.findAvailableFlights();
        }
    }

    private static void changePricing()
    {
        System.out.println(" 4: Change seat price.");
    }

    private static void bookSeat()
    {
        /*char type = travelMethod().toUpperCase().charAt(0);
        if (type == 'C')
        {
            seaSysMgr.bookSeat();
        }
        else if (type == 'T')
        {
            trainSysMgr.bookSeat();
        }
        else
        {
            airSysMgr.bookSeat();
        }*/
    }

    private static void displaySystem()
    {
        char type = travelMethod().toUpperCase().charAt(0);
        if (type == 'C')
        {
            seaSysMgr.displaySystemDetails();
        }
        else if (type == 'T')
        {
            trainSysMgr.displaySystemDetails();
        }
        else
        {
            airSysMgr.displaySystemDetails();
        }
    }

    private static void saveAMS()
    {
        System.out.println(" 7: Serialize airport system into an AMS file.");
    }

    private static void deleteSystem()
    {
        char type = travelMethod().toUpperCase().charAt(0);
        if (type == 'C')
        {
            seaSysMgr = new SystemManager();
        }
        else if (type == 'T')
        {
            trainSysMgr = new SystemManager();
        }
        else
        {
            airSysMgr = new SystemManager();
        }
    }
}
