
/*
10.a. Write Java programs to Implement All-Pairs Shortest Paths problem using Floyd's algorithm.
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Number of Vertices");
        int n = scanner.nextInt();
        int[][][] D = new int[n + 1][n][n];

        System.out.println("Enter Distance Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[0][i][j] = scanner.nextInt();
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    D[k][i][j] = Math.min(D[k - 1][i][j], D[k - 1][i][k - 1] + D[k - 1][k - 1][j]);
                }
            }
        }

        System.out.println("Shortest Distance Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(D[n][i][j] + " ");
            }
            System.out.println();
        }
    }
}