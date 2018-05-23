package sorting;

import java.util.Random;

public class BasicSorts
{
    public static void main(String[] args)
    {

        int[] array = new int[10];

        array[0] = 10;
        array[1] = 0;
        array[2] = 0;
        array[3] = 0;
        array[4] = 0;
        array[5] = 11;
        array[6] = 1;



    }

    public static void bubbleSort(int[] array)
    {
        if (array.length == 0 || array.length == 1)
        {
            return; // already sorted
        }

        for (int i = 0; i < array.length - 1; i++)
        {
            //elements after array.length - 1 - i are already sorted
            for (int j = 0; j < array.length - 1 - i; j++)
            {
                if (array[j] > array[j + 1])
                {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] array)
    {
        // for each element starting with the second element (the first is
        // already sorted)
        for (int i = 1; i < array.length; i++)
        {
            // loop down to the first element swapping the current
            // element with any other elements that are higher than it
            for (int j = i; j >= 1; j--)
            {
                if (array[j] < array[j - 1])
                {
                    swap(array, j, j - 1);
                }
                else
                {
                    // stop now, since all elements to the left are already sorted
                    break;
                }
            }
        }
    }

    public static void selectionSort(int[] array)
    {
        if (array.length == 0 || array.length == 1)
        {
            return; // already sorted
        }

        // make n selections, where n is array.length
        for (int i = 0; i < array.length; i++)
        {
            int smallest = array[i];
            int smallestIndex = i;

            // find the next smallest element for index i
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < smallest)
                {
                    smallest = array[j];
                    smallestIndex = j;
                }
            }

            // swap whatever is in index i with the next smallest element
            swap(array, i, smallestIndex);
        }
    }

    private static void swap(int[] array, int first, int second)
    {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static <T extends Comparable<T>> void insertionSortWithComparable(T[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            for (int j = i; j >= 1; j--)
            {
                if (array[j].compareTo(array[j - 1]) < 0)
                {
                    swap(array, j, j - 1);
                }
                else
                {
                    break;
                }
            }
        }
    }

    private static void swap(Object[] array, int first, int second)
    {
        Object temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static boolean detectInversions(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1])
            {
                return true;
            }
        }

        return false;
    }

    private static int[] generateRandomArray(int size, int low, int high)
    {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = low + random.nextInt(high - low + 1);
        }

        return array;
    }

    private static void shellSort(int[] the_array)
    {
        //delta is the gap for each iteration of insertion sort on a sub-array
        for (int delta = the_array.length / 2; delta > 0; delta /= 2)
        {
            //perform insertion sort on this sub-array
            for (int j = delta; j < the_array.length; j++)
            {
                for (int k = j; k >= delta; k -= delta)
                {
                    if (the_array[k] < the_array[k - delta])
                    {
                        swap(the_array, k, k - delta);
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
    }
}