package airTravel;

import travel.SeatClass;
import travel.Section;

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
	
	private Airline parseAirline(String s) 
	{
		int dataStart = delemeterIndex(s,"[",0)+1;
		String name = s.substring(0,dataStart-1);
		
		Airline al = new Airline(name);
		
		String[] flights = s.substring(dataStart).split("],");
		
		return al;
	}
	
	private Flight parseFlight(String s)
	{
		int dataStart = delemeterIndex(s,"|",0)+1;
		String name = s.substring(0,dataStart-1);
		String[] data = s.substring(dataStart).split("|");
		
		String[] dates = data[1].split(",");
		
		int sectionInfoDataStart = delemeterIndex(data[3],"[",0);
		String sectionInfo = data[3].substring(sectionInfoDataStart+1);
		data[3] = data[3].substring(0,sectionInfoDataStart);
		
		Flight f = new Flight(name,data[2],data[3],
				Integer.parseInt(dates[0]),
				Integer.parseInt(dates[1]),
				Integer.parseInt(dates[2]),
				Integer.parseInt(dates[3]),
				Integer.parseInt(dates[4]));
		
		String[] sections = sectionInfo.split(",");
		for(String section : sections) {
			parseSection(f,section);
		}
		
		return f;
		
	}
	
	private void parseSection(String flightName,Airline airline, String s)
	{
		String[] data = s.split(":");
		
		SeatClass seatClass;
		if(data[0].equals("F"))
			seatClass = SeatClass.first;
		else if(data[0].equals("B"))
			seatClass = SeatClass.business;
		else
			seatClass = SeatClass.economy;
		
		Section section = new FlightSection(
				seatClass,
				Integer.parseInt(data[3]),
				data[2].toCharArray()[0],
				Double.parseDouble(data[1]));
		airline.addFlightSection(flightName, section);
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
