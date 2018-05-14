
/*
10.b. Write Java programs to Implement Travelling Sales Person problem using Dynamic programming.
*/

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int[][] graph;
    static int[] path, tempPath;
    static int n;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of cities");
        n = scanner.nextInt();

        path = new int[n];
        tempPath = new int[n];
        graph = new int[n][n];

        System.out.println("Enter Adjacency Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter Source City");
        int src = scanner.nextInt();

        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (i == (src - 1)) {
                continue;
            }
            set.add(i);
        }

        int cost = tsp(src - 1, set);
        System.out.println("Total Cost: " + cost);

        System.out.print("Path: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print((path[i] + 1) + " ");
        }
        System.out.println();
    }

    static int tsp(int v, ArrayList<Integer> set) {
        if (set.isEmpty()) {
            return graph[v][0];
        }
        int size = set.size();
        ArrayList<Integer> subSet;
        int minCost = Integer.MAX_VALUE;
        for (Integer i : set) {
            subSet = new ArrayList<Integer>(set);
            subSet.remove(i);
            int cost = graph[v][i] + tsp(i, subSet);
            // minCost = Math.min(minCost, cost);
            if (cost < minCost) {
                minCost = cost;
                tempPath[size - 1] = i;
                if (size == n - 1) {
                    copyArray(path, tempPath);
                }
            }
        }
        return minCost;
    }

    static void copyArray(int[] dest, int[] src) {
        for (int i = 0; i < n; i++) {
            dest[i] = src[i];
        }
    }
}