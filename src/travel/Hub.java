package travel;

public abstract class Hub
{
    private String name;

    protected Hub(String name)
    {
        if (validateName(name))
        {
            this.name = name;
        }
    }

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

    public final String getName()
    {
        return this.name;
    }

    public abstract void display();

    protected abstract String getAMSmemento();
}
