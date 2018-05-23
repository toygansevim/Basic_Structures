package hashSet;

public class Clown
{

    private String name;
    private int popularity;

    public Clown(String name, int popularity)
    {
        this.name = name;
        this.popularity = popularity;
    }

    public int hashCode()
    {
        int value = 0;

        for (int i = 0; i < name.length(); i++)
        {
            char character = name.charAt(i);

            value += character;
        }

        return popularity + value;
    }


    public String getName()
    {
        return name;
    }

    public int getPopularity()
    {
        return popularity;
    }
}
