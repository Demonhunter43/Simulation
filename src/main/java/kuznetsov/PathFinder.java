package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Grass;
import main.java.kuznetsov.entity.Herbivore;

import java.util.HashMap;
import java.util.Map;

public class PathFinder {
    public static int minDistance;
    public static Coordinates target;

    public static Coordinates findPath(Entity entity, Map map) {
        Coordinates currentCoordinates = new Coordinates(0, 0);
        Coordinates target = findNearestTarget(entity, map);
        return new Coordinates(1, 1);

    }

    public static Coordinates findNearestTarget(Entity entity, Map map) {
        minDistance = 2147483647;
        map.forEach((coordinates, entityLambda) -> {
            if (entity.getClass() == (new Herbivore()).getClass()) { //grass
                if ((entity.getCoordinates().getDistanceTo((Coordinates) coordinates) != 0) && (entity.getCoordinates().getDistanceTo((Coordinates) coordinates) < minDistance) && (entityLambda.getClass() == (new Grass()).getClass())){
                    minDistance = entity.getCoordinates().getDistanceTo((Coordinates) coordinates);
                    target = (Coordinates) coordinates;
                }
            } else {
                if ((entity.getCoordinates().getDistanceTo((Coordinates) coordinates) != 0) && (entity.getCoordinates().getDistanceTo((Coordinates) coordinates) < minDistance) && (entityLambda.getClass() == (new Herbivore()).getClass())){
                    minDistance = entity.getCoordinates().getDistanceTo((Coordinates) coordinates);
                    target = (Coordinates) coordinates;
                }
            }
        });
        return target;
    }
}