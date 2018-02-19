
/*
1.b. Write a Java program to implement the Stack using arrays. Write Push(), Pop(), and
Display() methods to demonstrate its working.
*/

import java.util.Scanner;

class Stack {
    private int arr[], top, size;

    public Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int i) {
        if (top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = i;
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Element Popped is: " + arr[top--]);
    }

    public void display() {
        if (top == -1) {
            System.out.print("Empty\n");
            return;
        }
        System.out.print("\nStack: ");
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i] + " ");
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Size of Integer Stack ");
        int n = scanner.nextInt();

        Stack stack = new Stack(n);

        while (true) {
            System.out.println("\nStack Operations");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
            case 1:
                System.out.println("Enter integer element to push");
                stack.push(scanner.nextInt());
                break;

            case 2:
                stack.pop();
                break;

            case 3:
                stack.display();
                break;

            case 4:
                scanner.close();
                return;
            }
        }
    }
}