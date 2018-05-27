package travel;

public abstract class Section {
	private Seat[][] seats;
	private String name;
	
	public Section(String name) {
		
	}
	
	public boolean hasAvailableSeat() {
		return false;
	}
}
