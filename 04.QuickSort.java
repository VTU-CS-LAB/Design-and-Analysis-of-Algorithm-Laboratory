
/*
4. Sort a given set of n integer elements using Quick Sort method and compute its time
complexity. Run the program for varied values of n> 5000 and record the time taken to sort.
Plot a graph of the time taken versus non graph sheet. The elements can be read from a file or
can be generated using the random number generator. Demonstrate using Java how the divideand-conquer
method works along with its time complexity analysis: worst case, average case
and best case.
*/

import java.util.Scanner;

class QuickSort {

    static int[] arr;

    static void quickSort(int low, int high) {
        if (low < high) {
            int j = partition(low, high);
            quickSort(low, j - 1);
            quickSort(j + 1, high);
        }
    }

    static int partition(int low, int high) {
        int pivot = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (i < high && arr[i] <= pivot) {
                i = i + 1;
            }

            while (j > low && arr[j] >= pivot) {
                j = j - 1;
            }
            if (i < j) {
                interchange(i, j);
            }
        }
        arr[low] = arr[j];
        arr[j] = pivot;
        return j;
    }

    static void interchange(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value");
        n = scanner.nextInt();
        arr = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        quickSort(0, n - 1);
        System.out.println("Sorted Array");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}