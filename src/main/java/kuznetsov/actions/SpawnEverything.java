package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.*;

import java.util.Random;

public class SpawnEverything extends Action{
    public void doAction(MapField map, int numberOfHerbivores, int numberOfPredators, int numberOfRocks, int numberOfTrees){
        Random random = new Random();
        int x = map.length + 1;
        int y = map.height + 1;
        for (int i = 0; i < numberOfHerbivores; i++) {
            while (x > map.length || y > map.height || map.map.containsKey(new Coordinates(x,y))){
                x = random.nextInt(map.length + 1);
                y = random.nextInt(map.height + 1);
            }
            map.map.put(new Coordinates(x,y), new Herbivore(new Coordinates(x,y)));
        }
        for (int i = 0; i < numberOfPredators; i++) {
            while (x > map.length || y > map.height || map.map.containsKey(new Coordinates(x,y))){
                x = random.nextInt(map.length + 1);
                y = random.nextInt(map.height + 1);
            }
            map.map.put(new Coordinates(x,y), new Predator(new Coordinates(x,y)));
        }
        for (int i = 0; i < numberOfRocks; i++) {
            while (x > map.length || y > map.height || map.map.containsKey(new Coordinates(x,y))){
                x = random.nextInt(map.length + 1);
                y = random.nextInt(map.height + 1);
            }
            map.map.put(new Coordinates(x,y), new Rock(new Coordinates(x,y)));
        }
        for (int i = 0; i < numberOfTrees; i++) {
            while (x > map.length || y > map.height || map.map.containsKey(new Coordinates(x,y))){
                x = random.nextInt(map.length + 1);
                y = random.nextInt(map.height + 1);
            }
            map.map.put(new Coordinates(x,y), new Tree(new Coordinates(x,y)));
        }
        for (int i = 0; i < numberOfHerbivores * 2; i++) {
            while (x > map.length || y > map.height || map.map.containsKey(new Coordinates(x,y))){
                x = random.nextInt(map.length + 1);
                y = random.nextInt(map.height + 1);
            }
            map.map.put(new Coordinates(x,y), new Grass(new Coordinates(x,y)));
        }
    }
}