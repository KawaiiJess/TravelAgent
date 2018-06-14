package travel;

public enum SeatClass
{
    first, economy, business;

    public static SeatClass getfromName(String type)
    {
        if (type.equals("first"))
        {
            return SeatClass.first;
        }
        if (type.equals("business"))
        {
            return SeatClass.business;
        }
        if (type.equals("economy"))
        {
            return SeatClass.economy;
        }
        return null;
    }
}