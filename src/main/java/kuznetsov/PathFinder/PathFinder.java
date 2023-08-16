package main.java.kuznetsov.PathFinder;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Grass;
import main.java.kuznetsov.entity.Herbivore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PathFinder {
    public static int minDistance;
    public static Coordinates target;


    public static Coordinates findNextCoordinates(Entity entity, MapField map) {
        Cell startCell = new Cell(entity.getCoordinates(), 0, 0, 0, new Cell());

        PriorityQueue<Cell> openList = new PriorityQueue<>();
        openList.add(startCell);

        HashMap<Coordinates, Cell> closedList = new HashMap<>();
        Cell currentCell;
        while (!openList.isEmpty()) {
            currentCell = openList.peek();
            if (currentCell.coordinates.getDistanceTo(target) == 1) { // neighbour to target
                while (!currentCell.home.equals(startCell)) {
                    currentCell = currentCell.home;
                }
                return currentCell.coordinates;
            }
            closedList.put(currentCell.coordinates, currentCell);
            ArrayList<Cell> neighbours = addNeighboursToArrayList(currentCell, map);
            int newDistanceToHome = 0;
            for (Cell neighbour :
                    neighbours) {
                if (closedList.containsKey(neighbour.coordinates)) {
                    continue;
                }
                newDistanceToHome = currentCell.distanceToHome + 1;
                if (openList.contains(neighbour)) {
                    if (newDistanceToHome < neighbour.distanceToHome) {
                        openList.remove(neighbour);
                        neighbour.distanceToHome = newDistanceToHome;
                        neighbour.distanceToTarget = neighbour.coordinates.getDistanceTo(target);
                        neighbour.setCost(neighbour.distanceToHome + neighbour.distanceToTarget);
                        neighbour.home = currentCell;
                        openList.add(neighbour);
                    }
                } else {
                    neighbour.distanceToHome = newDistanceToHome;
                    neighbour.distanceToTarget = neighbour.coordinates.getDistanceTo(target);
                    neighbour.setCost(neighbour.distanceToHome + neighbour.distanceToTarget);
                    neighbour.home = currentCell;
                    openList.add(neighbour);
                    openList.remove(currentCell);
                }
            }
        }
        return new Coordinates(-1, -1);
    }

    private static ArrayList<Cell> addNeighboursToArrayList(Cell currentCell, MapField map) {
        ArrayList<Cell> neighbours = new ArrayList<>();
        Coordinates neighbour = new Coordinates(currentCell.coordinates.getX(), currentCell.coordinates.getY() + 1);
        if (neighbour.fitInMap(map) && !map.map.containsKey(neighbour)) {
            neighbours.add(new Cell(neighbour, 0, 0, 0, currentCell));
        }
        neighbour = new Coordinates(currentCell.coordinates.getX(), currentCell.coordinates.getY() - 1);
        if (neighbour.fitInMap(map) && !map.map.containsKey(neighbour)) {
            neighbours.add(new Cell(neighbour, 0, 0, 0, currentCell));
        }
        neighbour = new Coordinates(currentCell.coordinates.getX() + 1, currentCell.coordinates.getY());
        if (neighbour.fitInMap(map) && !map.map.containsKey(neighbour)) {
            neighbours.add(new Cell(neighbour, 0, 0, 0, currentCell));
        }
        neighbour = new Coordinates(currentCell.coordinates.getX() - 1, currentCell.coordinates.getY());
        if (neighbour.fitInMap(map) && !map.map.containsKey(neighbour)) {
            neighbours.add(new Cell(neighbour, 0, 0, 0, currentCell));
        }
        return neighbours;
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