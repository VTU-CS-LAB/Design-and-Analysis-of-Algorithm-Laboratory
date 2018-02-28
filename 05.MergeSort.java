
/*
5. Sort a given set of n integer elements using Merge Sort method and compute its time
complexity. Run the program for varied values of n> 5000, and record the time taken to sort.
Plot a graph of the time taken versus non graph sheet. The elements can be read from a file or
can be generated using the random number generator. Demonstrate using Java how the divideand-conquer
method works along with its time complexity analysis: worst case, average case
and best case. 
*/

/*
    Temporary Uploaded.
*/

import java.util.Scanner;

class MergeSort {

    static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
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
            if (arr[i] <= arr[j]) {
                t_arr[k] = arr[i];
                i++;
            } else {
                t_arr[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            t_arr[k] = arr[i];
            i++;
            k++;
        }
        while (j <= high) {
            t_arr[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0; k < n; k++) {
            arr[low + k] = t_arr[k];
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n value");
        n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        System.out.println("Sorted Array");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}