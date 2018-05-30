
/*
3.b. Write a Java program that implements a multi-thread application that has three threads.
First thread generates a random integer for every 1 second; second thread computes the
square of the number and prints; third thread will print the value of cube of the number.
*/

import java.util.Random;

class Generator extends Thread {
    static int number;

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            number = random.nextInt(10) + 1;
            System.out.println("\nRandom Number: " + number);

            Main.square.interrupt();
            Main.cube.interrupt();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Square extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(99999);
            } catch (InterruptedException e) {
                System.out.println("Square: " + (Generator.number * Generator.number));
            }
        }
    }
}

class Cube extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(99999);
            } catch (InterruptedException e) {
                System.out.println("Cube: " + (Generator.number * Generator.number * Generator.number));
            }
        }
    }
}

class Main {
    static Thread generator;
    static Thread square;
    static Thread cube;

    public static void main(String[] args) {
        generator = new Generator();
        square = new Square();
        cube = new Cube();

        square.start();
        cube.start();
        generator.start();
    }
}