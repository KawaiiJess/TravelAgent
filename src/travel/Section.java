package travel;

public abstract class Section 
{
	private Seat[][] seats;
	private String name;
	
	protected Section(String name, int numRows, int numCols) 
	{
		seats = new Seat[numRows][];
		for(int i = 0; i < numRows; i++) 
		{
			seats[i] = new Seat[numCols];
			for(int j = 0; j < numCols; j++) 
				seats[i][j] = new Seat(i,j);
		}
		this.name = name;
	}
	
	protected boolean hasAvailableSeat() 
	{
		for(int i = 0; i < seats.length; i++) 
			for(int j = 0; j < seats[i].length; j++)
				if(!seats[i][j].isOccupied())
					return true;
		return false;
	}
	
	protected boolean bookSeat() 
	{
		for(int i = 0; i < seats.length; i++) 
			for(int j = 0; j < seats[i].length; j++)
				if(!seats[i][j].isOccupied()) {
					seats[i][j].fill();
					return true;
				}
			
		
		return false;
	}
	protected boolean bookSeat(int row, int col) 
	{
		if(!seats[row][col].isOccupied()) 
		{
			seats[row][col].fill();
			return true;
		}
		return false;
			
	}
	protected String getName() 
	{
		return this.name;
	}
}
