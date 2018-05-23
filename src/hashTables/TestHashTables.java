package hashTables;

import java.util.Iterator;
import java.util.Random;

public class TestHashTables
{
    public static void main(String[] args)
    {

        Random random = new Random();

        HashTable<String> numberTable = new HashTable<>();
        Iterator<String> myIterator = numberTable.iterator();

        for (int i = 1; i <= 5; i++)
        {
            numberTable.add("ADDING" + i + " : at");


        }


        for (int i = 1; i <= 5; i++)
        {
            System.out.println(myIterator.hasNext());

//                                            numberTable.add("ADDING" + i + " : at");

        }


        for (String number : numberTable)
        {
            System.out.println(number);
        }

        System.out.println(numberTable);


    }
}
