package travel;

import java.util.HashMap;

public class PricingManager {
	private HashMap<String,Double> pricing;
	
	PricingManager()
	{
		this.pricing = new HashMap<>();
	}
	
	double getPricing(String orig, String dest, SeatClass seatClass)
	{
		String tag = encodeFlight(orig,dest,seatClass);
		if(pricing.containsKey(tag)) 
			return pricing.get(tag);
		return 0;
		
	}
	
	void setPricing(String orig, String dest, SeatClass seatClass, double price)
	{
		if(orig == null || orig.isEmpty() || dest == null || dest.isEmpty() || seatClass == null || price < 0)
			throw new IllegalArgumentException("Bad param passed to setPricing");
		
		String tag = encodeFlight(orig,dest,seatClass);
		pricing.put(tag,price);
	}
	
	private String encodeFlight(String orig, String dest, SeatClass seatClass)
	{
		return orig + "|" + dest + "|" + seatClass;
	}
	
}
