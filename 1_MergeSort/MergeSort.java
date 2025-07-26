import java.util.*;
class MergeSort {

    // Main function to sort an array using Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Recursively sort the first and second halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the two halves
            merge(array, left, middle, right);
        }
    }

    // Merge function to combine two sorted halves
    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Temporary arrays to hold the split halves
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the temp arrays back into the main array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy any remaining elements from the left array
        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        // Copy any remaining elements from the right array
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String... args){
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

}