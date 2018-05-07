
/*
10.b. Write Java programs to Implement Travelling Sales Person problem using Dynamic programming.
*/

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int[][] graph;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of cities");
        int n = scanner.nextInt();

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

    }

    static int tsp(int v, ArrayList<Integer> set) {
        if (set.isEmpty()) {
            return graph[v][0];
        }

        ArrayList<Integer> subSet;
        int minCost = Integer.MAX_VALUE;
        for (Integer i : set) {
            subSet = new ArrayList<Integer>(set);
            subSet.remove(i);
            int cost = graph[v][i] + tsp(i, subSet);
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }
}