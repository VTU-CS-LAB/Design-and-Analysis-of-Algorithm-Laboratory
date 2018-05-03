
/*
3.a. Write a Java program to read two integers a andb. Compute a/b and print, when b is not
zero. Raise an exception when b is equal to zero.
*/

import java.lang.Exception;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (b != 0) {
            System.out.println("a/b = " + (a / b));
        } else {
            throw new Exception("b is zero");
        }
    }
}