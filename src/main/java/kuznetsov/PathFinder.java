package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Grass;
import main.java.kuznetsov.entity.Herbivore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PathFinder {
    public static int minDistance;
    public static Coordinates target;


    public static Coordinates findPath(Entity entity, MapField map) {
        Coordinates target = findNearestTarget(entity, map);
        ArrayList<Node> openArray = new ArrayList<Coordinates>();
        ArrayList<Coordinates> closedArray = new ArrayList<Coordinates>();
        Coordinates nextCoordinates;
        Coordinates currentCoordinates = entity.getCoordinates();
        while (!currentCoordinates.equals(target)){

        }
        return nextCoordinates;

    }

    public static Coordinates findNearestTarget(Entity entity, MapField map) {
        minDistance = 2147483647;
        map.map.forEach((coordinates, entityLambda) -> {
            if (entity.getClass() == (new Herbivore()).getClass()) { //grass
                if ((entity.getCoordinates().getDistanceTo(coordinates) != 0) && (entity.getCoordinates().getDistanceTo(coordinates) < minDistance) && (entityLambda.getClass() == (new Grass()).getClass())){
                    minDistance = entity.getCoordinates().getDistanceTo(coordinates);
                    target = coordinates;
                }
            } else {
                if ((entity.getCoordinates().getDistanceTo(coordinates) != 0) && (entity.getCoordinates().getDistanceTo(coordinates) < minDistance) && (entityLambda.getClass() == (new Herbivore()).getClass())){
                    minDistance = entity.getCoordinates().getDistanceTo(coordinates);
                    target =  coordinates;
                }
            }
        });
        return target;
    }


}