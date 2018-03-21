
/*
6.b. Implement in Java, the 0/1 Knapsack problem using Greedy method.
*/

import java.util.Scanner;

class Knapsack {

    private double[] weight, profit, ratio;
    private double capacity;

    Knapsack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Items");
        int n = scanner.nextInt();
        weight = new double[n];
        profit = new double[n];
        ratio = new double[n];

        System.out.println("Enter Weights of Items");
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextDouble();
        }

        System.out.println("Enter Profits of Items");
        for (int i = 0; i < n; i++) {
            profit[i] = scanner.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            ratio[i] = profit[i] / weight[i];
        }

        System.out.println("Enter Capacity of Knapsack");
        capacity = scanner.nextDouble();
    }

    int getNext() {
        int index = -1;
        double highest = 0;
        
        for (int i = 0; i < ratio.length; i++) {
            if (ratio[i] > highest) {
                highest = ratio[i];
                index = i;
            }
        }
        return index;
    }

    void fill() {
        double currentWeight = 0;
        double currentProfit = 0;
        while (currentWeight < capacity) {
            int item = getNext();

            if (item == -1) {
                break;
            }

            System.out.print((item + 1) + " ");
            System.out.println();

            if (currentWeight + weight[item] <= capacity) {
                currentWeight += weight[item];
                currentProfit += profit[item];
                ratio[item] = 0;
            } else {
                currentProfit += ratio[item] * (capacity - currentWeight);
                break;
            }
        }

        System.out.println("Maximum Profit is: " + currentProfit);
    }
}

class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.fill();
    }
}