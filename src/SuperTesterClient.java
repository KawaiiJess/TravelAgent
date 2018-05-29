import airTravel.SystemManager;
import travel.SeatClass;

public class SuperTesterClient 
{
	public static void main(String[] args) 
	{
        SystemManager res = new SystemManager();
        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        res.createAirport("DEN");//invalid
        res.createAirport("DENW");//invalid
        res.createAirport(null);
        res.createAirport("");
        
        
        res.createAirline("DELTA");
        res.createAirline("AMER");
        res.createAirline("FRONT");
        res.createAirline("FRONTIER"); //invalid
        res.createAirline("FRONT"); //invalid
        res.createAirline(null);
        res.createAirline("");
        
        
        res.createFlight("DELTA", "DEN", "LON", 2018, 10, 10, "123");
        res.createFlight("DELTA", "DEN", "DEN", 2018, 8, 8, "567abc");//same airport
        res.createFlight("DEL", "DEN", "LON", 2018, 9, 8, "567"); //invalid airline
        res.createFlight("DELTA", "LON33", "DEN33", 2019, 5, 7, "123");//invalid airports
        res.createFlight("AMER", "DEN", "LON", 2010, 40, 100, "123abc");//invalid date
        res.createFlight(null, null, null, 2018, 10, 10, "124"); //null values
        res.createFlight("DELTA", "DEN", "LON", -1, -1, -1, "125"); //bad date
        res.createFlight("DELTA", "DEN", "LON", 2018, 10, 10, null); //null flight
        
        
        res.createSection("DELTA", "123", 2, 2, SeatClass.economy);
//        res.createSection("DELTA", "123", 2, 3, SeatClass.first);
//        res.createSection("DELTA", "123", 2, 3, SeatClass.first);//Invalid
//        res.createSection("SWSERTT", "123", 5, 5, SeatClass.economy);//Invalid airline
//        res.createSection("DELTA", "123", 2, 2,null);				   	//null class
//        res.createSection("DELTA", "123", 0, 0, SeatClass.business);   	//no seats
//        res.createSection("DELTA", "123", 101, 8, SeatClass.business); 	//too many rows
//        res.createSection("DELTA", "123", 80, 20, SeatClass.business); 	//too many columns

        
/*        res.bookSeat("DELTA", "123", SeatClass.first, 1, 'A');
        res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A');
        res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'B');
        res.bookSeat("DELTA888", "123", SeatClass.business, 1, 'A'); //Invalid airline
        res.bookSeat("DELTA", "123haha7", SeatClass.business, 1, 'A'); //Invalid flightId
        res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A'); //already booked
        res.bookSeat(null, "123", SeatClass.first, 1, 'A');
        res.bookSeat("DELTA", null, SeatClass.first, 1, 'A');
        res.bookSeat("DELTA", "123", null, 1, 'A');
        res.bookSeat("DELTA", "123", SeatClass.first, 2, 'Q');*/
        
        res.displaySystemDetails();
        res.findAvailableFlights("DEN", "LON");
        res.findAvailableFlights("DEN", "LONasdawd");
        res.findAvailableFlights("DasdasdaEN", "LON");
        res.findAvailableFlights(null, "LON");
        res.findAvailableFlights("DEN", null);
	}
}
