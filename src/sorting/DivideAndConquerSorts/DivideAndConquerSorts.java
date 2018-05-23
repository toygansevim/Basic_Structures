package sorting.DivideAndConquerSorts;

import java.util.Arrays;

public class DivideAndConquerSorts
{
    private static int[] temp;

    public static void main(String[] args)
    {
        int[] testArray = {13, 1, 46, -10, 20, 100, 33, 94, 2, 15};
        mergeSort(testArray);

        System.out.println(Arrays.toString(testArray));

    }


    public static void mergeSort(int[] array)
    {

        //preconditions
        if (array.length == 0 || array.length == 1)
        {
            return; //array already sorted

        }

        //Need another O(n) SPACE
        temp = new int[array.length];

        // 0 to the highest point
        mergeSort(array, 0, array.length - 1);


    }

    /**
     * @param array given array to be sorted
     * @param low   lowest index in the given subarray
     * @param high  highest index in the given subarrray
     */
    private static void mergeSort(int[] array, int low, int high)
    {

        //BASE CASE
        if (high - low == 0) //1 element where indexes are same
        {
            return; // we can merge our elements later
        }

        //RECURSIVE CALL
        int mid = (high + low )/ 2;

        mergeSort(array, low, mid); //LEFT SUB ARRAY
        mergeSort(array, mid + 1, high); //RIGHT SUB ARRAY

        //merge two sorted sub-arrays
        merge(array, low, mid, mid + 1, high);


    }

    private static void merge(int[] array, int lowLeft, int highLeft, int lowRight, int highRight)
    {

        //create a few temp variables ot help with the merge steps belows

        int left = lowLeft, right = lowRight; //this will keep track of the i and j values of the 2 merging
        // array's
        // index position to receive elements
        int count = highRight - lowLeft + 1; // number of elements

        for (int i = 0; i < count; i++) // go through for each element
        {//Check if the sub array's are still full?

            //have we exhausted from the left sub array?
            if (left > highLeft)
            {
                temp[lowLeft + i] = array[right];
                right++; //move the right array indicies to forward to get remaining elements

            }

            //have we finished removing all the elements from the right sub array?
            if (right > highRight)
            {
                temp[lowLeft + i] = array[left];
                left++;
            }

            //is the left element the smallest?
            else if (array[left] < array[right])
            {
                temp[lowLeft + i] = array[left];
                left++;
            }

            //is the right element the smallest?
            else if (array[right] <= array[left])
            {
                temp[lowLeft + i] = array[right];
                right++;
            }
        }

        //Copy the results from the temporary array to original back
        for (int i = 0; i < count; i++)
        {
            array[lowLeft + i] = temp[lowLeft + i];
        }

    }
}
