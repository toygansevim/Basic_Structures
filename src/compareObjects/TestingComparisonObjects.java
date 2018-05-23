package compareObjects;

import java.util.Arrays;
import java.util.Scanner;

public class TestingComparisonObjects
{
    public static void main(String[] args)
    {
        ColoredPencil[] pencils = {
                new ColoredPencil("red", 10, .99),
                new ColoredPencil("blue", 8, .99),
                new ColoredPencil("green", 10, .66),
                new ColoredPencil("red", 10, .97),
                new ColoredPencil("red", 9, .77),
                new ColoredPencil("orange", 7, .99),
        };


        Scanner console = new Scanner(System.in);

        System.out.println("1. Sort by point size\n2. Sort by price");
        int menuChoice = console.nextInt();

        if (menuChoice == 1)
        {
            Arrays.sort(pencils, new PointSizeComparator());
        }
        else if (menuChoice == 2)
        {

            Arrays.sort(pencils, new PriceComparator());
        }
/*
        ColoredPencil pencil1 = pencils[3];
        ColoredPencil pencil2 = pencils[5];

        if (pencil1.compareTo(pencil2) < 0)
        {
            System.out.println("Pencil 2 is biggger");
        }
        else if (pencil1.compareTo(pencil2) > 0)
        {
            System.out.println("Pencil 1 is bigger");
        }
        else
        {
            System.out.println("Pencil's are equal");
        }*/


        for (int i = 0; i < pencils.length; i++)
        {
            System.out.println(pencils[i]);
        }
    }

}
