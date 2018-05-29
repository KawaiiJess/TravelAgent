package airTravel;

import travel.Company;
import travel.SeatClass;
import travel.Section;
import travel.Trip;

class Airline extends Company
{
    Airline(String name) throws IllegalArgumentException
    {
        super(validateName(name));
    }

    private static String validateName(String name)
    {
        String nameUpper = name.toUpperCase();
        if (nameUpper.length() < 7 && nameUpper.length() > 0)
        {
            char[] chars = nameUpper.toCharArray();
            for (char c : chars)
            {
                if (!Character.isLetterOrDigit(c))
                {
                    throw new IllegalArgumentException();
                }
            }
            return nameUpper;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    boolean createFlightSection(String flight, SeatClass seatClass, int rows, int cols)
    {
        Section s;
        try
        {
            s = new FlightSection(seatClass, rows, cols);
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }

        return super.addSection(flight, s);
    }

    protected void display()
    {
        System.out.println("Airline: " + super.getName() + " \n\tFlights: ");
        super.display();
    }

    String[] getFlight(String orig, String dest)
    {
        return super.getTrips(orig, dest);
    }

    boolean addFlight(String name, String source, String dest, int year, int month, int day)
    {
        if (name == null)
        {
            System.out.println("Null is not a valid flight ID!");
            return false;
        }
        else
        {
            try
            {
                Trip t = new Flight(name, source, dest, year, month, day);
                super.addTrip(t);
            }
            catch (Exception e)
            {
                return false;
            }

            return true;
        }
    }

    boolean bookSeat(String fID, SeatClass s, int row, char col)
    {
        char colUpper = Character.toUpperCase(col);
        int colInt = ((int) colUpper) - 65;
        if (colInt < 0 || colInt > 9)
        {
            System.out.println("Seat index out of range.");
            return false;
        }
        else
        {
            return super.bookSeat(fID, s, row, colInt);
        }
    }
}