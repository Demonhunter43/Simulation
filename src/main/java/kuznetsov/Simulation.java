package main.java.kuznetsov;

import main.java.kuznetsov.actions.*;
import main.java.kuznetsov.entity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    static ArrayList<Action> initActions = new ArrayList<Action>();
    static ArrayList<Action> turnActions = new ArrayList<Action>();

    static MapField map;
    static int counter;
    static MapConsoleRender renderer;
    static int numberOfHerbivore = 1;

    public static void main(String[] args) {
        startSimulation();
    }

    private static void startSimulation() {
        initializeActions();
        initializeSimulation();

        Scanner scanner = new Scanner(System.in);
        String command = "";
        boolean isPaused = false;
        // while for commands
        while (true) {
            if (command.equals("")) {
                System.out.println("1 - to start endless simulation\n" +
                        "2 - to make one iteration\n" +
                        "3 - to pause\n" +
                        "4 - to exit");
                command = scanner.nextLine();
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
                    command = "";
            }
        }
    }

    private static void initializeActions() {
        initActions.add(new SpawnEverything());
        turnActions.add(new MoveAllCreatures());
        turnActions.add(new AttackNeighbours());
        turnActions.add(new SpawnGrass());
        turnActions.add(new SpawnHerbivore());
    }

    private static void initializeSimulation() {
        // init actions
        int height = 20;
        int length = 15;
        counter = 0;
        map = new MapField(height, length);
        renderer = new MapConsoleRender();
        Herbivore herbivore = new Herbivore(new Coordinates(0, 0));
        Predator predator = new Predator(new Coordinates(7, 3));
        map.put(new Coordinates(0, 0), herbivore);
        map.put(new Coordinates(2, 9), new Grass(new Coordinates(2, 9)));
        map.put(new Coordinates(7, 3), predator);
        map.put(new Coordinates(3, 9), new Rock(new Coordinates(3, 9)));
        map.put(new Coordinates(7, 6), new Tree(new Coordinates(7, 6)));
        MapConsoleRender.render(map);
    }

    private static String startEndlessSimulation() {
        while (numberOfHerbivore > 0) {

        }
        String command = "";
        return command;
    }

    private static void nextTurn() {
        if (numberOfHerbivore > 0) {
            map.map.forEach((coordinates, cell) -> {

            });
        }
    }

    private static void pauseSimulation() {
        System.out.println("The game is paused!");
    }
}