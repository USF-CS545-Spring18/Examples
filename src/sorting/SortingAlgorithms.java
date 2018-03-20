package sorting;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * A class that contains static methods for sorting an array of integers using
 * various sorting methods.
 * The code of several sorting methods was modified from the code of Prof. Galles.
 */
public class SortingAlgorithms {

    /** Print a given array of integers */
    public static void print(int[] arr) {
        for (int elem : arr)
            System.out.print(elem + " ");
        System.out.println();
    }

    /** Print a given array of records */
    public static void print(Elem[] arr) {
        for (Elem elem : arr)
            System.out.print(elem + " ");
        System.out.println();
    }

    /** Sort a given array using selection sort */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin])
                    indexOfMin = j;
            }
            // swap
            int tmp = arr[indexOfMin];
            arr[indexOfMin] = arr[i];
            arr[i] = tmp;
        }
    }

    /**
     * Sort a given array using bubble sort. At each pass, we "bubble up" the
     * current smallest element
     */
    public static void bubbleSort(int[] arr) {
        for (int pos = 0; pos < arr.length - 1; pos++) {
            for (int j = arr.length - 1; j > pos; j--) {
                if (arr[j] < arr[j - 1]) {
                    // swap them
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }

    }

    /** Sort a given array using insertion sort */
    public static void insertionSort(int[] arr) {
        int curr;
        int j;
        for (int i = 1; i < arr.length; i++) {
            curr = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j]; // shift elems to the right
                j--;
            }
            arr[j + 1] = curr;

        }
    }

    /**
     * Sort a given array using shell sort and n/2, n/4, n/8 etc increments. The
     * code is modified from the code of Prof. Galles.
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int increment, offset;
        for (increment = n / 2; increment > 0; increment = increment / 2)
            for (offset = 0; offset < increment; offset++)
                insertionSort(arr, offset, increment);
    }

    /**
     * Another version of the insertion sort that sorts a sublist of a given
     * list. Used in Shell Sort. Takes an offset (the first element of the list
     * will be at arr[offset]) and increment (the gap between the elements of
     * the list)
     */
    public static void insertionSort(int[] arr, int offset, int increment) {
        int i, j;
        int n = arr.length;
        for (i = offset + increment; i < n; i = i + increment) {
            int curr = arr[i];
            j = i - increment;
            while (j >= 0 && arr[j] > curr) {
                arr[j + increment] = arr[j];
                j = j - increment;
            }
            arr[j + increment] = curr;
        }
    }

    /** public method for mergeSort - called from outside of the class */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    /**
     * A private mergeSort method - takes an array, a temporary array, and the
     * indices that specify what part of the list we are working with (we need
     * to sort the part from low to high)
     *
     * @param arr
     * @param temp
     * @param low
     * @param high
     */
    private static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low >= high)
            return;
        // divide in half
        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);
        merge(arr, temp, low, mid, high); // merge two sorted halves into one
        // sorted list
    }

    /**
     * Merge two sorted sublists together, one that goes from low to mid another
     * goes from mid+1 to high. Uses a temporary array.
     *
     * @param arr
     * @param temp
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        int k = low;
        int i = low;
        int j = mid + 1;
        while (k <= high) {
            if (i > mid) {// ran out of elements in the i sublist
                temp[k] = arr[j];
                k++;
                j++;
            } else if (j > high) {// ran out of elements in the j sublist
                temp[k] = arr[i];
                k++;
                i++;
            } else if (arr[i] < arr[j]) { // place arr[i] in temp, move i
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j]; // place arr[j] in temp, move j
                k++;
                j++;
            }
        }
        // copy the result from temp back to arr
        for (k = low; k <= high; k++)
            arr[k] = temp[k];
    }

    /**
     * Quick sort
     * @param arr Array of integers
     */
    public static void quickSort(int arr[]) {

        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Quick sort method that takes low and high indices
     * @param arr array to sort
     * @param low the index where we should start sorting the array
     * @param high the index where we want to finish sorting the array
     */
    public static void quickSort(int arr[], int low, int high) {
        int pivot; // index of the pivot
        if (low < high) {
            pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    /**
     * Helper method for quickSort.
     * @param arr array of integers
     * @param low the starting value of i
     * @param high the starting value of j
     * @return
     */
    static int partition(int arr[], int low, int high) {
        int pivot;
        int tmp;
        int max = high;
        int mid = (low + high) / 2;

        tmp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = tmp;
        pivot = arr[high];
        low--;
        do {
            while ((low < high) && (arr[++low] < pivot))
                ;
            while ((low < high) && (arr[--high] > pivot))
                ;
            // swap values at low and high
            tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
        } while (low < high);
        tmp = arr[low];
        arr[low] = arr[max];
        arr[max] = tmp;
        return low;
    }

}
