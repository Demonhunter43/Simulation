package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;

public abstract class Action {
    public void doAction(MapField map, int numberOfHerbivores, int numberOfPredators, int numberOfRocks, int numberOfTrees){
    }
    public int doAction(MapField map){
        int counter = 1;
        return counter;
    }
}