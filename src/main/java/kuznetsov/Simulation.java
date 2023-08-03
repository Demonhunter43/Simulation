package main.java.kuznetsov;

import main.java.kuznetsov.actions.Action;
import main.java.kuznetsov.entity.*;

import java.util.Scanner;

public class Simulation {
    static final Action[] initActions = new Action[]{

    };
    static final Action[] turnActions = new Action[]{

    };
    static Map map;
    static int counter;
    static int length;
    static int height;
    static MapConsoleRender renderer;

    public static void main(String[] args) {
        System.out.println("Main menu \n" +
                "Type 'start' or 'exit'");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = "";
            command = scanner.nextLine();
            switch (command) {
                case ("start"):
                    System.out.println("Ok, let's go");
                    startSimulation();
                    break;
                case ("exit"):
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Don't know this command");
            }
        }
    }

    private static void startSimulation() {
        initializeSimulation();

        Scanner scanner = new Scanner(System.in);
        String command = "";
        boolean isPaused = false  ;
        // while for commands
        while (true) {
            if (command.equals("")){
                command = scanner.nextLine();
                System.out.println("1 - to start endless simulation\n" +
                        "2 - to make one iteration\n" +
                        "3 - to pause\n" +
                        "4 - to exit");
            }
            switch (command) {
                case ("1"):
                    isPaused = false;
                    command = startEndlessSimulation();
                    break;
                case ("2"):
                    isPaused = false;
                    nextTurn();
                    command = "";
                    break;
                case ("3"):
                    if (!isPaused) {
                        pauseSimulation();
                        isPaused = true;
                        command = "";
                    } else {
                        System.out.println("The game is already paused");
                    }
                    break;
                case ("4"):
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("Don't know this command");
            }
        }
    }

    private static void initializeSimulation() {
        // init actions
        height = 10;
        length = 10;
        counter = 0;
        map = new Map();
        renderer = new MapConsoleRender();
        map.put(new Coordinates(0, 0), new Herbivore());
        map.put(new Coordinates(2, 9), new Grass());
        map.put(new Coordinates(6, 2), new Predator());
        map.put(new Coordinates(3, 9), new Rock());
        map.put(new Coordinates(7, 6), new Tree());

        MapConsoleRender.render(length, height, map);
    }

    private static String startEndlessSimulation() {
        while (map.containsValue(new Herbivore())){

        }
        String command = "";
        return command;
    }

    private static void nextTurn() {
    }

    private static void pauseSimulation() {
        System.out.println("The game is paused!");
    }
}