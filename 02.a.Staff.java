
/*
2.a. Design a superclass called Staff with details as StaffId, Name, Phone, Salary. Extend
this class by writing three subclasses namely Teaching (domain, publications),
Technical (skills), and Contract (period). Write a Java program to read and display at
least 3 staff objects of all three categories.
*/

import java.util.Scanner;

class Staff {
    private String staffId;
    private String name;
    private int phone;
    private float salary;

    public void accept() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Staff Id");
        staffId = scanner.next();
        System.out.println("Enter Name");
        name = scanner.next();
        System.out.println("Enter Phone");
        phone = scanner.nextInt();
        System.out.println("Enter Salary");
        salary = scanner.nextFloat();
    }

    public void display() {
        System.out.println("Staff Id: " + staffId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Salary: " + salary);
    }
}


class Teaching extends Staff {
    private String domain;
    private String[] publications;

    public void accept() {
        super.accept();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Domain");
        domain = scanner.next();
        System.out.println("Enter Number of Publications");
        int n = scanner.nextInt();
        publications = new String[n];
        System.out.println("Enter Publications");
        for (int i = 0; i < n; i++) {
            publications[i] = scanner.next();
        }
    }

    public void display() {
        super.display();
        System.out.println("Domain: " + domain);
        System.out.println("Publications:");
        for (int i = 0; i < publications.length; i++) {
            System.out.println(publications[i]);
        }
    }
}


class Technical extends Staff {
    private String[] skills;

    public void accept() {
        super.accept();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Skills");
        int n = scanner.nextInt();
        skills = new String[n];
        System.out.println("Enter Skills");
        for (int i = 0; i < n; i++) {
            skills[i] = scanner.next();
        }
    }

    public void display() {
        super.display();
        System.out.println("Skills:");
        for (int i = 0; i < skills.length; i++) {
            System.out.println(skills[i]);
        }
    }
}


class Contract extends Staff {
    private int period;

    public void accept() {
        super.accept();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Period");
        period = scanner.nextInt();
    }

    public void display() {
        super.display();
        System.out.println("Period: " + period);
    }
}


class Main {
    public static void main(String[] args) {
        Teaching teaching = new Teaching();
        Technical technical = new Technical();
        Contract contract = new Contract();

        System.out.println("Enter Details for Teaching Staff Member");
        teaching.accept();
        System.out.println("Enter Details for Technical Staff Member");
        technical.accept();
        System.out.println("Enter Details for Contract Staff Member");
        contract.accept();

        System.out.println("Details for Teaching Staff Member are");
        teaching.display();
        System.out.println("Details for Technical Staff Member are");
        technical.display();
        System.out.println("Details for Contract Staff Member are");
        contract.display();
    }
}