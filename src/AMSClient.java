import airTravel.AirportFactory;
import airTravel.SystemManager;

public class AMSClient
{
    public static void main(String[] args)
    {

        AirportFactory f = new AirportFactory();
        String test = "[DEN, NYC, SEA, LAX]{AMER[AA1|2018, 10, 8, 16, 30|DEN|LAX[E:200:S:4,F:50\n0:S:2], AA2|2018, 8, 9, 7, 30|LAX|DEN[E:200:S:5,F:500:S:3]], UNTD[UA21|2018, 11, 8, 12, 30|NYC|SEA[E:300:S:6, F:800:S:3], UA12|2018, 8, 9, 7, 30|SEA|DEN[B:700:S:5, F:1200:S:2]]}";
        SystemManager testManager = f.buildAirportSystem(test, 'A');
        //System.out.println("First Read===================");
        testManager.displaySystemDetails();
        //SystemManager test2 = f.buildAirportSystem(testManager.getAMS(), 'A');
        //System.out.println("Second Read===================");
        //test2.displaySystemDetails();
    }
}