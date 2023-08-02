package main.java.kuznetsov;

import main.java.kuznetsov.entity.*;



public class Simulation {
    private static Map map;
    private static int counter;
    private static int length;
    private static int height;
    private static MapConsoleRender renderer;

    public Simulation(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public void nextTurn(){
    }
    public void start() {
        map = new Map();
        renderer = new MapConsoleRender();
        counter = 0;
        map.put(new Coordinates(0,0), new Herbivore());
        map.put(new Coordinates(2,9), new Grass());
        map.put(new Coordinates(6,2), new Predator());
        map.put(new Coordinates(3,9), new Rock());
        map.put(new Coordinates(7,6), new Tree());

        MapConsoleRender.render(length, height, map);
    }
    public void pause(){
    }
}
