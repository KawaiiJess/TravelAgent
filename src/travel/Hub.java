package travel;

public abstract class Hub
{
    public static boolean validateName(String name) throws IllegalArgumentException
    {
        String nameUpper = name.toUpperCase();
        if (nameUpper.length() == 3)
        {
            char[] chars = nameUpper.toCharArray();
            for (char c : chars)
            {
                if (!Character.isLetter(c))
                {
                    throw new IllegalArgumentException();
                }
            }
            return true;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public abstract String getName();

    public abstract void display();
}
