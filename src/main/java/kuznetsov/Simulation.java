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
        height = 10;
        length = 10;
        counter = 0;
        System.out.println("Main menu \n" +
                "Type\n" +
                        "'start'\n" +
                        "'exit'");
        Scanner scanner = new Scanner(System.in);

        while (true){
            String command = "";
            command = scanner.nextLine();
            switch(command) {
                case ("start"):
                    System.out.println("Ok, let's go");
                    map = new Map();
                    renderer = new MapConsoleRender();
                    counter = 0;
                    map.put(new Coordinates(0,0), new Herbivore());
                    map.put(new Coordinates(2,9), new Grass());
                    map.put(new Coordinates(6,2), new Predator());
                    map.put(new Coordinates(3,9), new Rock());
                    map.put(new Coordinates(7,6), new Tree());

                    MapConsoleRender.render(length, height, map);
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
}