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
    static int numberOfHerbivore = 3;

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
                System.out.println("Number of herbivores: " + numberOfHerbivore + "/n" +
                        "Number of iterations: " + iterationsCounter);
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
        initActions.add(new SpawnEverything());     //0

        
        turnActions.add(new MoveAllCreatures());    //0
        turnActions.add(new AttackAllNeighbours()); //1
        turnActions.add(new SpawnGrass());          //2
        turnActions.add(new SpawnHerbivore());      //3
    }

    private static void initializeSimulation() {
        // init actions
        int height = 20;
        int length = 15;
        iterationsCounter = 0;
        map = new MapField(height, length);
        renderer = new MapConsoleRender();
        initActions.get(0).doAction(map, numberOfHerbivore, 1, 3, 4);
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
            turnActions.get(0).doAction(map);
            turnActions.get(1).doAction(map);
            iterationsCounter++;
        } else {
            System.out.println("Травоядные закончились, пока!");
            System.exit(0);
        }
    }

    private static void pauseSimulation() {
        System.out.println("The game is paused!");
    }
}