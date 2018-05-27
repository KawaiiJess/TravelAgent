package travel;

public class EmptySeat implements Seat {
	private static Seat instance;
	
	public Seat getInstance() {
		if(instance == null)
			instance = new EmptySeat();
		return instance;
	}
	
	@Override
	public boolean isOccupied() {
		return false;
	}

}
