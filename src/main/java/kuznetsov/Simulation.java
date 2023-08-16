package main.java.kuznetsov;

import main.java.kuznetsov.actions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    static ArrayList<Action> initActions = new ArrayList<>();
    static ArrayList<Action> turnActions = new ArrayList<>();

    static MapField map;
    static int iterationsCounter;
    static MapConsoleRender renderer;
    static int numberOfHerbivore = 2;
    public static String command = "";

    public static void main(String[] args) {
        startSimulation();
    }

    private static void startSimulation() {
        initializeActions();
        initializeSimulation();

        Scanner scanner = new Scanner(System.in);
        boolean isPaused = false;
        // while for commands
        while (true) {
            if (command.equals("")) {
                System.out.println("1 - to start endless simulation\n" +
                        "2 - to make one iteration\n" +
                        "3 - to pause\n" +
                        "4 - to exit");
                System.out.println("Number of herbivores: " + numberOfHerbivore + ", iteration: " + iterationsCounter);
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
                        isPaused = pauseSimulation();
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
        initActions.add(new SpawnEverything());     //0


        turnActions.add(new MoveAllCreatures());    //0
        turnActions.add(new AttackAllNeighbours()); //1
        turnActions.add(new SpawnGrass());          //2
        turnActions.add(new SpawnHerbivore());      //3
    }

    private static void initializeSimulation() {
        // init actions
        int length = 15;
        int height = 10;
        iterationsCounter = 0;
        map = new MapField(height, length);
        renderer = new MapConsoleRender();
        initActions.get(0).doAction(map, numberOfHerbivore, 1, 1, 2);
        MapConsoleRender.render(map);
    }

    private static String startEndlessSimulation() {
        while (numberOfHerbivore > 0) {
            nextTurn();

        }
        String command = "";
        return command;
    }

    private static void nextTurn() {
        if (numberOfHerbivore > 0) {
            int deaths = turnActions.get(1).doAction(map);
            numberOfHerbivore = numberOfHerbivore - deaths;
            turnActions.get(0).doAction(map);
            iterationsCounter++;
            MapConsoleRender.render(map);
        } else {
            System.out.println("No more herbivores, bye!");
            System.exit(0);
        }
        command = "";
    }

    private static boolean pauseSimulation() {
        System.out.println("The game is paused!");
        return true;
    }
}