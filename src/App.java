import java.util.Arrays;

public class App <T extends Comparable<T>> {

    public void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    public void merge(T[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] L = Arrays.copyOfRange(array, left, mid + 1);
        T[] R = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) { 
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public void bubbleSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0 ) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        App<Integer> app = new App<>();
        Integer[] array = {5, 20, 80, 12, 57, 9, 2, 3, 8};
        
        // Mergesort time
        long startMergeSort = System.nanoTime();
        app.mergeSort(array, 0, array.length - 1);
        long endMergeSort = System.nanoTime();
        long timeTakenMergeSort = endMergeSort - startMergeSort;
        System.out.println("MergeSort result: " + Arrays.toString(array));
        System.out.println("Time taken by MergeSort: " + timeTakenMergeSort + " nanoseconds");

        // Bubblesort time
        Integer[] array2 = {5, 20, 80, 12, 57, 9, 2, 3, 8};
        long startBubbleSort = System.nanoTime();
        app.bubbleSort(array2);
        long endBubbleSort = System.nanoTime();
        long timeTakenBubbleSort = endBubbleSort - startBubbleSort;
        System.out.println("BubbleSort result: " + Arrays.toString(array2));
        System.out.println("Time taken by BubbleSort: " + timeTakenBubbleSort + " nanoseconds");

        // Time comparison
        if (timeTakenMergeSort < timeTakenBubbleSort) {
            System.out.println("MergeSort is faster than BubbleSort");
        } else {
            System.out.println("BubbleSort is faster than MergeSort");
        }
    }

}



