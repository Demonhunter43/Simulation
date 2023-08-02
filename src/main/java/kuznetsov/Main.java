package main.java.kuznetsov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Type 'start' or 'exit'");
        Scanner scanner = new Scanner(System.in);
        String command = "";
        command = "start"; //scanner.nextLine();

        switch(command) {
            case ("start"):
                System.out.println("Ok, let's go");
                Simulation currentSimulation = new Simulation(10, 10);
                currentSimulation.start();
                break;
            case ("exit"):
                System.out.println("Bye(");
                System.exit(0);
                break;
            default:
                System.out.println("Don't know this command");
        }
        System.out.println("Bye");
    }
}