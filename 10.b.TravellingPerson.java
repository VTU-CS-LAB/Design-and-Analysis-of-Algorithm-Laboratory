
/*
10.b. Write Java programs to Implement Travelling Sales Person problem using Dynamic programming.
*/

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int[][] graph;
    static int n, src;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of cities");
        n = scanner.nextInt();

        graph = new int[n][n];

        System.out.println("Enter Adjacency Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter Source City");
        src = scanner.nextInt();

        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (i == (src - 1)) {
                continue;
            }
            set.add(i);
        }

        int[] path = new int[n + 1];
        path[0] = src - 1;
        path[n] = src - 1;

        int cost = tsp(src - 1, set, path);
        System.out.println("Total Cost: " + cost);

        System.out.print("Path: ");
        for (int i = n; i >= 0; i--) {
            System.out.print((path[i] + 1) + " ");
        }
        System.out.println();
    }

    static int tsp(int v, ArrayList<Integer> set, int[] path) {
        if (set.isEmpty()) {
            return graph[v][src - 1];
        }
        int size = set.size();
        ArrayList<Integer> subSet;
        int minCost = Integer.MAX_VALUE;
        for (Integer i : set) {
            subSet = new ArrayList<Integer>(set);
            subSet.remove(i);
            int[] tempPath = path.clone();
            int cost = graph[v][i] + tsp(i, subSet, tempPath);

            if (cost < minCost) {
                minCost = cost;
                tempPath[size] = i;
                copyArray(path, tempPath, size);
            }
        }
        return minCost;
    }

    static void copyArray(int[] dest, int[] src, int size) {
        for (int i = 0; i <= size; i++) {
            dest[i] = src[i];
        }
    }
}

// ///////
// Output:
//
// Enter number of cities
// 4
// Enter Adjacency Matrix
// 0 10 15 20
// 5 0 9 10
// 6 13 0 12
// 8 8 9 0
// Enter Source City
// 1
// Total Cost: 35
// Path: 1 2 4 3 1