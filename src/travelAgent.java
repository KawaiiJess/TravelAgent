import airTravel.AirportFactory;
import airTravel.SystemManager;
import travel.Company;
import travel.Hub;
import travel.SeatClass;
import travel.Trip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

    private static void subMenu()
    {
        System.out.println("===================Travel Agent===================");
        System.out.println(" 1: Add a company.");
        System.out.println(" 2: Add a hub.");
        System.out.println(" 3: Add a trip.");
        System.out.println(" 4: Add a section.");
        System.out.println("-1: Return to previous menu.");
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
        String temp = user.next().toUpperCase();
        while (!temp.equals("A") && !temp.equals("C"))
        {
            temp = user.next();
            System.out.println("'A' or 'C' only please.");
        }
        return temp;
    }

    private static String getFile() throws IOException
    {
        System.out.print("Enter the name of your AMS file without extension: ");
        File file = new File(user.next() + ".ams");
        if (file.exists() && file.isFile())
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = br.readLine();
            br.close();
            return s;
        }
        return "";
    }

    private static char determineTravelType(String AMS)
    {
        return AMS.toUpperCase().charAt(0);
    }

    private static String getHub()
    {
        boolean isHubValid = false;
        while (true)
        {
            String hub = user.next().toUpperCase();
            isHubValid = Hub.validateName(hub);
            if (isHubValid)
            {
                return hub;
            }
        }
    }

    private static int[] getDate()
    {
        int[] date = new int[3];

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
                date[0] = year;
                date[1] = month;
                date[2] = day;
            }
        }
        return date;
    }

    private static char getSeatPreference()
    {
        System.out.println("Do you have a seat preference (Window, Aisle, Neither)?: ");
        String temp = user.next().toUpperCase();
        return temp.charAt(0);
    }

    private static String getCompanyName()
    {
        boolean nameValid = false;
        while (true)
        {
            System.out.println("Company?: ");
            String name = user.next().toUpperCase();
            try
            {
                nameValid = Company.validateName(name);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
            if (nameValid)
            {
                return name;
            }
        }
    }

    private static String getFlightID()
    {
        System.out.println("Flight ID?: ");
        return user.next();
    }

    private static ArrayList<Object> getSeatInfo()
    {
        ArrayList<Object> seatInfo = new ArrayList<>();

        seatInfo.add(getCompanyName());

        seatInfo.add(getFlightID());

        seatInfo.add(getSeatClass());

        System.out.println("Row?: ");
        seatInfo.add(intParam());

        System.out.println("Column?: ");
        seatInfo.add(determineTravelType(user.next())); //Grab first char

        return seatInfo;
    }

    private static SeatClass getSeatClass()
    {
        SeatClass temp = null;
        while (true)
        {
            System.out.println("Class?: ");
            String className = user.next().toLowerCase();
            temp = SeatClass.getfromName(className);
            if (temp != null)
            {
                return temp;
            }
        }
    }

    private static void addCompany()
    {

    }

    private static void addHub()
    {

    }

    private static void addTrip()
    {

    }

    private static void addSection()
    {

    }


    //1: Generate system using an AMS file.
    private static void loadAMS()
    {
        try
        {
            String AMS = getFile();
            char type = determineTravelType(AMS);
            if (!AMS.equals(""))
            {
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
                    AirportFactory f = new AirportFactory();
                    airSysMgr = f.buildAirportSystem(AMS, type);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    //2: Generate system manually.
    private static void generateManually() //Make a second menu to manually perform sampleclient operations.
    {
        subMenu();
        int choice = intParam();
        while (choice > 0)
        {
            switch (choice)
            {
                case 1:
                    addCompany();
                    break;
                case 2:
                    addHub();
                    break;
                case 3:
                    addTrip();
                    break;
                case 4:
                    addSection();
                    break;
                default:
                    addCompany();
            }
            System.out.print("\n\n");
            subMenu();
            choice = intParam();
        }
    }


    //3: Query available trips.
    private static void queryAvailable()
    {
        char type = travelMethod().charAt(0);
        int[] date = getDate();
        System.out.println("Origin?: ");
        String orig = getHub();
        System.out.println("Destination?: ");
        String dest = getHub();
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
            airSysMgr.findAvailableFlights(orig, dest, date[0], date[1], date[2]);
        }
    }


    //4: Change seat price.
    private static void changePricing()
    {
        System.out.println(" 4: Change seat price.");
    }


    //5: Book a seat.
    private static void bookSeat()
    {
        char type = travelMethod().toUpperCase().charAt(0);
        if (type == 'C')
        {
            //seaSysMgr.bookSeat();
        }
        else if (type == 'T')
        {
            //trainSysMgr.bookSeat();
        }
        else
        {
            char pref = getSeatPreference();
            if (pref == 'W' || pref == 'A')
            {
                boolean window = false;
                boolean aisle = false;
                if (pref == 'W')
                {
                    window = true;
                }
                else
                {
                    aisle = true;
                }
                airSysMgr.bookSeat(getCompanyName(), getFlightID(), getSeatClass(), window, aisle);
            }
            else
            {
                ArrayList<Object> seatInfo = getSeatInfo();
                airSysMgr.bookSeat((String) seatInfo.get(0), (String) seatInfo.get(1), (SeatClass) seatInfo.get(2), (int) seatInfo.get(3), (char) seatInfo.get(4));
            }
        }
    }


    //6: Display system.
    private static void displaySystem()
    {
        char type = travelMethod().charAt(0);
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


    //7: Delete system.
    private static void deleteSystem()
    {
        char type = travelMethod().charAt(0);
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


    private static String getYesNo()
    {
    	String input = "";
    	while(!input.equals("y") && !input.equals("n"))
    	{
    		System.out.print("(y/n): ");
    		input = user.next();
    		System.out.print("\n");
    	}
    	return input;
    }
    
    //8: Serialize airport system into an AMS file.
    private static void saveAMS()
    {
    	String ams = airSysMgr.getAMS();
    	System.out.print("Please choose a name for your save file without extension: ");
        File file = new File(user.next() + ".ams");
        if (file.exists())
        {
            System.out.println("That file allready exists. Would you like to overwrite it?");
        	if(getYesNo().equals("y"))
        	{
        		file.delete();
        		writeToFile(file,ams);
        		System.out.println("File Successfully Overwritten");
        	}else
        		System.out.println("File Not Saved!");
        }else {
        	writeToFile(file,ams);
        	System.out.print("File Saved Successfully");
        }
    }
    
    private static void writeToFile(File f, String toWrite)
    {
    	try {
	    	if(!f.exists())
	    		f.createNewFile();
	        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	        bw.write(toWrite);
	        bw.close();
	        
    	}catch(IOException e) {}
    }
}