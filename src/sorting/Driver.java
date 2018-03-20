package sorting;

public class Driver {
    public static void main(String[] args) {
        int[] arr = {4, 2, 10, 1, 13, 16, 3, 5};
        System.out.println("Before sorting:");
        SortingAlgorithms.print(arr);
        System.out.println("After sorting with quick sort:");
        SortingAlgorithms.quickSort(arr);
        SortingAlgorithms.print(arr);


    }
}
