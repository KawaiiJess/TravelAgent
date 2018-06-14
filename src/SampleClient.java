import airTravel.AirportFactory;
import airTravel.SystemManager;

public class SampleClient
{
    public static void main(String[] args)
    {
    	
        /*SystemManager res = new SystemManager();
        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        res.createAirport("DEN");//invalid
        res.createAirport("DENW");//invalid
        res.createAirline("DELTA");
        res.createAirline("AMER");
        res.createAirline("FRONT");
        res.createAirline("FRONTIER"); //invalid
        res.createAirline("FRONT"); //invalid
        res.createFlight("DELTA", "DEN", "LON", 2018, 10, 10, "123");
        res.createFlight("DELTA", "DEN", "DEN", 2018, 8, 8, "567abc");//same airport
        res.createFlight("DEL", "DEN", "LON", 2018, 9, 8, "567"); //invalid airline
        res.createFlight("DELTA", "LON33", "DEN33", 2019, 5, 7, "123");//invalid airports
        res.createFlight("AMER", "DEN", "LON", 2010, 40, 100, "123abc");//invalid date
        res.createSection("DELTA", "123", 2, 2, SeatClass.economy);
        res.createSection("DELTA", "123", 2, 3, SeatClass.first);
        res.createSection("DELTA", "123", 2, 3, SeatClass.first);//Invalid
        res.createSection("SWSERTT", "123", 5, 5, SeatClass.economy);//Invalid airline
        res.bookSeat("DELTA", "123", SeatClass.first, 1, 'A');
        res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A');
        res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'B');
        res.bookSeat("DELTA888", "123", SeatClass.business, 1, 'A'); //Invalid airline
        res.bookSeat("DELTA", "123haha7", SeatClass.business, 1, 'A'); //Invalid flightId
        res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A'); //already booked
        res.displaySystemDetails();
        res.findAvailableFlights("DEN", "LON");*/

        AirportFactory f = new AirportFactory();
        String test = "[DEN, NYC, SEA, LAX]{AMER[AA1|2018, 10, 8, 16, 30|DEN|LAX[E:200:S:4,F:50\n0:S:2], AA2|2018, 8, 9, 7, 30|LAX|DEN[E:200:S:5,F:500:S:3]], UNTD[UA21|2018, 11, 8, 12, 30|NYC|SEA[E:300:S:6, F:800:S:3], UA12|2018, 8, 9, 7, 30|SEA|DEN[B:700:S:5, F:1200:S:2]]}";
        SystemManager testManager = f.buildAirportSystem(test, 'A');
        System.out.println("First Read===================");
        testManager.displaySystemDetails();
        SystemManager test2 = f.buildAirportSystem(testManager.getAMS(),'A');
        System.out.println("Second Read===================");
        test2.displaySystemDetails();

    }
}