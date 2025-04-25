import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Generate an array of random integers between 1 and 100, of size 10000
        int[] randomNumbers = generateRandomNumbers(1, 100, 10000);
        
        // Sort the array using merge sort
        performMergeSort(randomNumbers, 0, randomNumbers.length - 1);
        
        // Display the sorted array
        displayArray(randomNumbers);
        System.out.println();
    }

    // Generates an array of random integers within a specified range and size
    public static int[] generateRandomNumbers(int minValue, int maxValue, int arraySize) {
        Random randomGenerator = new Random();
        int[] generatedArray = new int[arraySize];
        
        // Fill the array with random integers
        for (int i = 0; i < arraySize; i++) {
            generatedArray[i] = randomGenerator.nextInt(maxValue - minValue + 1) + minValue;
        }
        return generatedArray;
    }

    // Performs merge sort on the given array
    public static void performMergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            
            // Recursively divide the array into two halves
            performMergeSort(array, leftIndex, middleIndex);
            performMergeSort(array, middleIndex + 1, rightIndex);
            
            // Merge the two sorted halves
            mergeSortedHalves(array, leftIndex, middleIndex, rightIndex);
        }
    }

    // Merges two sorted subarrays into a single sorted array
    private static void mergeSortedHalves(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;

        // Create temporary arrays for the left and right halves
        int[] leftSubarray = new int[leftArraySize];
        int[] rightSubarray = new int[rightArraySize];

        // Copy the data to the temporary arrays
        System.arraycopy(array, leftIndex, leftSubarray, 0, leftArraySize);
        System.arraycopy(array, middleIndex + 1, rightSubarray, 0, rightArraySize);

        int i = 0, j = 0, k = leftIndex;

        // Merge the two subarrays back into the original array
        while (i < leftArraySize && j < rightArraySize) {
            if (leftSubarray[i] <= rightSubarray[j]) {
                array[k++] = leftSubarray[i++];
            } else {
                array[k++] = rightSubarray[j++];
            }
        }

        // Copy any remaining elements from the left subarray
        while (i < leftArraySize) {
            array[k++] = leftSubarray[i++];
        }

        // Copy any remaining elements from the right subarray
        while (j < rightArraySize) {
            array[k++] = rightSubarray[j++];
        }
    }

    // Displays the elements of the array
    public static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + "\t");
        }
    }
}
