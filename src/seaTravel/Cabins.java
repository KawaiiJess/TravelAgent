package seaTravel;

import travel.SeatClass;
import travel.Section;

public class Cabins extends Section
{
	Cabins(int numCabins) throws IllegalArgumentException
	{
		super(SeatClass.economy, numCabins,1);
	}
	
	boolean bookRoom(int roomNum)
	{
		return super.bookSeat(roomNum,0);
	}
}
