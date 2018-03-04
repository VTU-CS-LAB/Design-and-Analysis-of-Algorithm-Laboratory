
/*
5. Sort a given set of n integer elements using Merge Sort method and compute its time
complexity. Run the program for varied values of n> 5000, and record the time taken to sort.
Plot a graph of the time taken versus non graph sheet. The elements can be read from a file or
can be generated using the random number generator. Demonstrate using Java how the divideand-conquer
method works along with its time complexity analysis: worst case, average case
and best case. 
*/

import java.util.Random;
import java.util.Scanner;

class MergeSort {
    static int comparisons = 0;

    static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            comparisons += 1;
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int arr[], int low, int mid, int high) {
        int n = high - low + 1;
        int[] t_arr = new int[n];
        int i = low, j = mid + 1, k = 0;
        while ((i <= mid) && (j <= high)) {
            comparisons += 2;
            if (arr[i] <= arr[j]) {
                t_arr[k] = arr[i];
                comparisons += 1;
                i++;
            } else {
                t_arr[k] = arr[j];
                comparisons += 1;
                j++;
            }
            k++;
        }
        while (i <= mid) {
            t_arr[k] = arr[i];
            comparisons += 1;
            i++;
            k++;
        }
        while (j <= high) {
            t_arr[k] = arr[j];
            comparisons += 1;
            j++;
            k++;
        }
        for (k = 0; k < n; k++) {
            comparisons += 1;
            arr[low + k] = t_arr[k];
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value");
        n = scanner.nextInt();
        int[] arr = new int[n];
        int ch;
        System.out.println("Merge Sort");
        System.out.println("1. Best Case");
        System.out.println("2. Average Case");
        System.out.println("3. Worst Case");
        ch = scanner.nextInt();
        switch (ch) {
        case 1:
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
            break;
        case 2:
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt();
            }
            break;
        case 3:
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }
            generateWorstCase(arr, 0, n - 1);
            break;
        }
        
        long start = System.nanoTime();
        mergeSort(arr, 0, n - 1);
        long end = System.nanoTime();
        System.out.println("Sorted Array");
        
        System.out.println("Time Taken: " + (end - start));
        System.out.println("Comparisons: " + comparisons);
    }

    static void generateWorstCase(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            partition(arr, low, high);
            generateWorstCase(arr, low, mid);
            generateWorstCase(arr, mid + 1, high);
        }
    }

    static void partition(int arr[], int low, int high) {
        int n = high - low + 1;
        int k = 0;
        int t_arr[] = new int[n];

        for (int i = low; i <= high; i += 2) {
            t_arr[k] = arr[i];
            k++;

        }

        for (int i = low + 1; i <= high; i += 2) {
            t_arr[k] = arr[i];
            k++;
        }

        for (int i = 0; i < n; i++) {
            arr[low + i] = t_arr[i];
        }
    }
}