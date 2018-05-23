package sorted;

import java.util.Random;

public class TestSortedList
{
    public static void main(String[] args)
    {
        SortedLinkedList myList = new SortedLinkedList();
        Random random = new Random();

        for (int i = 0 ; i <= 100; i++)
        {
            myList.add(random.nextInt(40)+1);
        }

        myList.print();
    }
}
