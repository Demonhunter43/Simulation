package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Grass;
import main.java.kuznetsov.entity.Herbivore;

import java.util.ArrayList;

public class PathFinder {
    public static int minDistance;
    public static Coordinates target;


    public static Coordinates findPath(Entity entity, MapField map) {
        int length = map.length;
        int height = map.height;
        Coordinates target = findNearestTarget(entity, map);
        ArrayList<Cell> openArray = new ArrayList<Cell>();
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
            } else {  // herbivore
                if ((entity.getCoordinates().getDistanceTo(coordinates) != 0) && (entity.getCoordinates().getDistanceTo(coordinates) < minDistance) && (entityLambda.getClass() == (new Herbivore()).getClass())){
                    minDistance = entity.getCoordinates().getDistanceTo(coordinates);
                    target =  coordinates;
                }
            }
        });
        return target;
    }
    public static boolean addNeighborsToArray (Cell activeCell, ArrayList<Cell> array, MapField map, Coordinates target ){
        Coordinates neighbour = new Coordinates(activeCell.coordinates.getX()-1, activeCell.coordinates.getY());
        int counter = 0;
        if (neighbour.fitInMap(map.length, map.height) && !map.map.containsKey(neighbour)){
            array.add(new Cell(neighbour, activeCell,activeCell.distanceToHome + 1, neighbour.getDistanceTo(target)));
            counter++;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX(), activeCell.coordinates.getY()-1);
        if (neighbour.fitInMap(map.length, map.height) && !map.map.containsKey(neighbour)){
            array.add(new Cell(neighbour, activeCell,activeCell.distanceToHome + 1, neighbour.getDistanceTo(target)));
            counter++;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX(), activeCell.coordinates.getY()+1);
        if (neighbour.fitInMap(map.length, map.height) && !map.map.containsKey(neighbour)){
            array.add(new Cell(neighbour, activeCell,activeCell.distanceToHome + 1, neighbour.getDistanceTo(target)));
            counter++;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX()+1, activeCell.coordinates.getY());
        if (neighbour.fitInMap(map.length, map.height) && !map.map.containsKey(neighbour)){
            array.add(new Cell(neighbour, activeCell,activeCell.distanceToHome + 1, neighbour.getDistanceTo(target)));
            counter++;
        }
        if (counter > 0) return true;
        else
            return false;

    }
}