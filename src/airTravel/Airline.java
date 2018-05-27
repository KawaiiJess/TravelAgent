package airTravel;

class Airline implements travel.Hub
{
    private String name;

    Airline(String name) throws IllegalArgumentException
    {
        String temp = name.toUpperCase();
        if (temp.length() == 3)
        {
            char[] chars = temp.toCharArray();
            for (char c : chars)
                if (!Character.isLetter(c))
                	throw new IllegalArgumentException();

            this.name = name;
        }
        else
            throw new IllegalArgumentException();

    }

    private getName() {
    	
    }
}
