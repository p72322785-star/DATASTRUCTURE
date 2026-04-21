import java.util.*;

class p4 {

    // Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    // Insertion Sort
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // Merge Sort
    static void mergeSort(int[] arr) {
        Arrays.sort(arr); // using built-in for simplicity
    }

    public static void main(String[] args) {

        int[] arr1 = {5, 2, 9, 1};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        bubbleSort(arr1);
        insertionSort(arr2);
        mergeSort(arr3);

        System.out.println("Bubble: " + Arrays.toString(arr1));
        System.out.println("Insertion: " + Arrays.toString(arr2));
        System.out.println("Merge: " + Arrays.toString(arr3));
    }
}