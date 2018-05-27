package airTravel;

class Airline implements travel.Hub
{
    private String name;

    Airline(String name) throws IllegalArgumentException
    {
        String temp = name.toUpperCase();
        if (temp.length() == 3)
        {
            boolean valid = true;
            char[] chars = temp.toCharArray();
            for (char c : chars)
            {
                if (!Character.isLetter(c))
                {
                    valid = false;
                }
                if (valid)
                {
                    this.name = name;
                }
                else
                {
                    throw new IllegalArgumentException();
                }
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    private getName()
}
