package compareObjects;

import java.util.Comparator;

public class PriceComparator implements Comparator<ColoredPencil>
{
    public int compare(ColoredPencil pencil1, ColoredPencil pencil2)
    {
        if (pencil1.getPrice() > pencil2.getPrice())
        {
            return 1;
        }
        else if (pencil1.getPrice() < pencil2.getPrice())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
