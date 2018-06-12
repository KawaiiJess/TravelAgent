import airTravel.AirportFactory;
import airTravel.SystemManager;

import java.io.*;
import java.util.Scanner;

public class travelAgent
{
    private static Scanner user = new Scanner(System.in);
    private static File file;
    private static SystemManager sysMgr;

    private static void displayMenu()
    {
        System.out.println("===================Travel Agent===================");
        System.out.println(" 1: Generate airport system using AMS file.");
        System.out.println(" 2: Generate system manually.");
        System.out.println(" 3: Query available trips.");
        System.out.println(" 4: Change seat price.");
        System.out.println(" 5: Book a seat.");
        System.out.println(" 6: Display system.");
        System.out.println(" 7: Serialize airport system into an AMS file.");
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
        file = new File(user.next() + ".ams");
        if (file.exists() && file.isFile())
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            return br.readLine();
        }
        return null;
    }

    private static void loadAMS()
    {
        System.out.println(" 1: Generate airport system using AMS file.");
        try
        {
            AirportFactory f = new AirportFactory();
            sysMgr = f.buildAirportSystem(getFile());
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
        System.out.println(" 3: Query available trips.");
    }

    private static void changePricing()
    {
        System.out.println(" 4: Change seat price.");
    }

    private static void bookSeat()
    {
        System.out.println(" 5: Book a seat.");
    }

    private static void displaySystem()
    {
        System.out.println(" 6: Display system.");
        sysMgr.displaySystemDetails();
    }

    private static void saveAMS()
    {
        System.out.println(" 7: Serialize airport system into an AMS file.");
    }
}
