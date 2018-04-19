
/*
8. Find Minimum Cost Spanning Tree of a given connected undirected graph using
Kruskal's algorithm. Use Union-Find algorithms in your program.
*/

import java.util.Arrays;
import java.util.Scanner;

class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Vertices");
        int n = scanner.nextInt();

        int adj[][] = new int[n][n];
        System.out.println("Enter Adjacency Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = scanner.nextInt();
            }
        }

        // Maximum Edges without any Loops can be ((n * (n - 1)) / 2).
        Edge[] edges = new Edge[(n * (n - 1)) / 2];

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges[k] = new Edge(i, j, adj[i][j]);
                k++;
            }
        }

        sort(edges);

        // Declare an array of size vertices to keep track of respective leaders of each element.
        int[] parent = new int[n];
        // Assign each element of array of with value -1.
        Arrays.fill(parent, -1);

        int minCost = 0;
        System.out.println("Edges: ");
        for (int i = 0; i < k; i++) {
            // Find the super most of leader of source vertex.
            int lsrc = find(parent, edges[i].src);
            // Find the super most of leader of destination vertex.
            int ldest = find(parent, edges[i].dest);

            // If those two leaders are different then they belong to isolated groups.
            if (lsrc != ldest) {
                System.out.println((edges[i].src + 1) + " <-> " + (edges[i].dest + 1));
                minCost += edges[i].weight;
                union(parent, lsrc, ldest);
            }
        }

        System.out.println();
        System.out.println("Minimum Cost of Spanning Tree: " + minCost);
    }

    static void sort(Edge[] edges) {
        // Sort Edges according to their weights using Bubble Sort.
        for (int i = 1; i < edges.length; i++) {
            for (int j = 0; j < edges.length - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    static int find(int[] parent, int i) {
        if (parent[i] == -1) {
            // Super Most Leader Element Found.
            return i;
        }
        // Find Above Leader in recurrsive manner.
        return find(parent, parent[i]);
    }

    static void union(int[] parent, int lsrc, int ldest) {
        // Make destination vertex leader of source vertex.
        parent[lsrc] = ldest;
    }
}