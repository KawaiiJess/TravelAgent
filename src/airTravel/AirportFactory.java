package airTravel;

public class AirportFactory 
{
	public SystemManager buildAirportSystem(String config)
	{
		config = removeWhitespace(config);
		
		
		int start = 1;
		int end = delemeterIndex(config, "]",start);
		String[] airportNames = config.substring(start,end).split(",");
		
		start = end+2;
		end = delemeterIndex(config,"}",start);
		String[] airlines = config.substring(start,end).split("]],");
		
		
		
		return null;
	}
	
	private int delemeterIndex(String search,String s, int start)
	{
		for(int i = start; i + s.length()<= search.length(); i++) {
			if(search.substring(i, i+s.length()).equals(s))
				return i+s.length()-1;
		}
		return -1;
	}
	
	private String removeWhitespace(String s)
	{
		StringBuilder temp = new StringBuilder("");
		for(char c : s.toCharArray()) 
		{
			if(c != ' ') {
				temp.append(c);
			}
		}
		return temp.toString();
	}
	
	
}
