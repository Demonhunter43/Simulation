package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.*;

import java.util.Random;

public class SpawnEverything extends Action {
    public void doAction(MapField map, int numberOfHerbivores, int numberOfPredators, int numberOfRocks, int numberOfTrees) {

        Coordinates newCoordinates;
        for (int i = 0; i < numberOfHerbivores; i++) {
            newCoordinates = getFreeRandomCoordinates(map);
            map.map.put(newCoordinates, new Herbivore(newCoordinates));
        }
        for (int i = 0; i < numberOfPredators; i++) {
            newCoordinates = getFreeRandomCoordinates(map);
            map.map.put(newCoordinates, new Predator(newCoordinates));
        }
        for (int i = 0; i < numberOfRocks; i++) {
            newCoordinates = getFreeRandomCoordinates(map);
            map.map.put(newCoordinates, new Rock(newCoordinates));
        }
        for (int i = 0; i < numberOfTrees; i++) {
            newCoordinates = getFreeRandomCoordinates(map);
            map.map.put(newCoordinates, new Tree(newCoordinates));
        }
        for (int i = 0; i < numberOfHerbivores * 2; i++) {
            newCoordinates = getFreeRandomCoordinates(map);
            map.map.put(newCoordinates, new Grass(newCoordinates));
        }
    }

    public Coordinates getFreeRandomCoordinates(MapField map) {
        Random random = new Random();
        int x, y;
        x = map.length;
        y = map.height;
        while (x >= map.length || y >= map.height || map.map.containsKey(new Coordinates(x, y))) {
            x = random.nextInt(map.length);
            y = random.nextInt(map.height);
        }
        return new Coordinates(x, y);
    }
}