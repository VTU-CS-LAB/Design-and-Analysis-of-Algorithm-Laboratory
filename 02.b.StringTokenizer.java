
/*
2.b. Write a Java class called Customer to store their name and date_of_birth. The
date_of_birth format should be dd/mm/yyyy. Write methods to read customer data as
<name, dd/mm/yyyy> and display as <name, dd, mm, yyyy> using StringTokenizer
class considering the delimiter character as "/".
*/

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.StringTokenizer;

class Customer {
    String name;
    String dob;
}

class Main {
    static Customer customer;

    public static void main(String[] args) {
        customer = new Customer();
        accept();
        display();
    }

    static void accept() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name and DoB");
        String input = scanner.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
        try {
            customer.name = stringTokenizer.nextToken().trim();
            customer.dob = stringTokenizer.nextToken().trim();
        } catch (NoSuchElementException e) {
            System.out.println("Invalid Format");
            System.exit(0);
        }
    }

    static void display() {
        StringTokenizer stringTokenizer = new StringTokenizer(customer.dob, "/");
        try {
            String dd = stringTokenizer.nextToken().trim();
            String mm = stringTokenizer.nextToken().trim();
            String yy = stringTokenizer.nextToken().trim();

            StringJoiner stringJoiner = new StringJoiner(", ");
            stringJoiner.add(customer.name).add(dd).add(mm).add(yy);

            System.out.println(stringJoiner.toString());
        } catch (NoSuchElementException e) {
            System.out.println("Invalid Format");
            System.exit(0);
        }
    }
}