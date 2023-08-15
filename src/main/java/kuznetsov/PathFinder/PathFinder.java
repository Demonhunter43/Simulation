package main.java.kuznetsov.PathFinder;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Grass;
import main.java.kuznetsov.entity.Herbivore;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathFinder {
    public static int minDistance;
    public static int minValue;
    public static Coordinates target;
    public static Cell bestCell;


    public static Coordinates findNextCoordinates(Entity entity, MapField map) {
        Cell startCell = new Cell(entity.getCoordinates(), 0, 0, 0, null);
        Cell endCell = new Cell(findNearestTarget(entity, map), 0, 0, 0, null);
        PriorityQueue<Cell> openList = new PriorityQueue<Cell>(Comparator<E> c);
        return nextCoordinates;
    }

    public static Coordinates findNearestTarget(Entity entity, MapField map) {
        minDistance = 2147483647;
        map.map.forEach((coordinates, entityLambda) -> {
            if (entity.getClass() == Herbivore.class) { //grass
                if ((entity.getCoordinates().getDistanceTo(coordinates) != 0) && (entity.getCoordinates().getDistanceTo(coordinates) < minDistance) && (entityLambda.getClass() == (new Grass()).getClass())) {
                    minDistance = entity.getCoordinates().getDistanceTo(coordinates);
                    target = coordinates;
                }
            } else {  // herbivore
                if ((entity.getCoordinates().getDistanceTo(coordinates) != 0) && (entity.getCoordinates().getDistanceTo(coordinates) < minDistance) && (entityLambda.getClass() == (new Herbivore()).getClass())) {
                    minDistance = entity.getCoordinates().getDistanceTo(coordinates);
                    target = coordinates;
                }
            }
        });
        return target;
    }
}