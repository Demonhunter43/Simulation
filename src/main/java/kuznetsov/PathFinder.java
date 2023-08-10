package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Grass;
import main.java.kuznetsov.entity.Herbivore;

import java.util.HashMap;

public class PathFinder {
    public static int minDistance;
    public static int minValue;
    public static Coordinates target;
    public static Cell bestCell;


    public static Coordinates findNextCell(Entity entity, MapField map) {
        Coordinates nextCoordinates;
        Coordinates target = findNearestTarget(entity, map);
        HashMap<Coordinates, Cell> openList = new HashMap<>();
        HashMap<Coordinates, Cell> closedList = new HashMap<>();
        Cell home = new Cell(entity.getCoordinates(), null, 0, entity.getCoordinates().getDistanceTo(target));
        Cell activeCell = home;
        closedList.put(activeCell.coordinates, home);
        if (!addNeighborsToList(activeCell, openList, map, target)) {
            System.out.println("One unit is blocked");
            return new Coordinates(-1, -1);
        }
        activeCell = findBestCellInList(openList, closedList);
        closedList.put(activeCell.coordinates, activeCell);
        while (!activeCell.coordinates.equals(target)) {
            addNeighborsToList(activeCell, openList, map, target);
            changeDistanceIfNecessary(activeCell, openList);
            activeCell = findBestCellInList(openList, closedList);
            closedList.put(activeCell.coordinates, activeCell);
        }
        nextCoordinates = activeCell.coordinates;
        while (!activeCell.equals(home)) {
            nextCoordinates = activeCell.coordinates;
            activeCell = activeCell.home;
        }
        return nextCoordinates;

    }

    private static void changeDistanceIfNecessary(Cell activeCell, HashMap<Coordinates, Cell> openList) {
        Coordinates neighbour = new Coordinates(activeCell.coordinates.getX() - 1, activeCell.coordinates.getY());
        if (openList.containsKey(openList.containsKey(neighbour) && (openList.get(neighbour).distanceToHome > (activeCell.distanceToHome + 1)))) {
            openList.get(neighbour).distanceToHome = activeCell.distanceToHome + 1;
            openList.get(neighbour).home = activeCell;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX() + 1, activeCell.coordinates.getY());
        if (openList.containsKey(openList.containsKey(neighbour) && (openList.get(neighbour).distanceToHome > (activeCell.distanceToHome + 1)))) {
            openList.get(neighbour).distanceToHome = activeCell.distanceToHome + 1;
            openList.get(neighbour).home = activeCell;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX(), activeCell.coordinates.getY() - 1);
        if (openList.containsKey(openList.containsKey(neighbour) && (openList.get(neighbour).distanceToHome > (activeCell.distanceToHome + 1)))) {
            openList.get(neighbour).distanceToHome = activeCell.distanceToHome + 1;
            openList.get(neighbour).home = activeCell;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX(), activeCell.coordinates.getY() + 1);
        if (openList.containsKey(openList.containsKey(neighbour) && (openList.get(neighbour).distanceToHome > (activeCell.distanceToHome + 1)))) {
            openList.get(neighbour).distanceToHome = activeCell.distanceToHome + 1;
            openList.get(neighbour).home = activeCell;
        }
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

    public static boolean addNeighborsToList(Cell activeCell, HashMap<Coordinates, Cell> listMap, MapField map, Coordinates target) {
        Coordinates neighbour = new Coordinates(activeCell.coordinates.getX() - 1, activeCell.coordinates.getY());
        int counter = 0;
        if (neighbour.equals(target)){
            listMap.put(neighbour, new Cell(neighbour, activeCell, activeCell.distanceToHome + 1, neighbour.calculateDistanceTo(target)));
            return true;
        }
        if (neighbour.fitInMap(map.length, map.height) && !map.map.containsKey(neighbour) && !listMap.containsKey(neighbour)) {
            listMap.put(neighbour, new Cell(neighbour, activeCell, activeCell.distanceToHome + 1, neighbour.calculateDistanceTo(target)));
            counter++;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX(), activeCell.coordinates.getY() - 1);
        if (neighbour.equals(target)){
            listMap.put(neighbour, new Cell(neighbour, activeCell, activeCell.distanceToHome + 1, neighbour.calculateDistanceTo(target)));
            return true;
        }
        if (neighbour.fitInMap(map.length, map.height) && !map.map.containsKey(neighbour) && !listMap.containsKey(neighbour)) {
            listMap.put(neighbour, new Cell(neighbour, activeCell, activeCell.distanceToHome + 1, neighbour.calculateDistanceTo(target)));
            counter++;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX(), activeCell.coordinates.getY() + 1);
        if (neighbour.equals(target)){
            listMap.put(neighbour, new Cell(neighbour, activeCell, activeCell.distanceToHome + 1, neighbour.calculateDistanceTo(target)));
            return true;
        }
        if (neighbour.fitInMap(map.length, map.height) && !map.map.containsKey(neighbour) && !listMap.containsKey(neighbour)) {
            listMap.put(neighbour, new Cell(neighbour, activeCell, activeCell.distanceToHome + 1, neighbour.calculateDistanceTo(target)));
            counter++;
        }
        neighbour = new Coordinates(activeCell.coordinates.getX() + 1, activeCell.coordinates.getY());
        if (neighbour.equals(target)){
            listMap.put(neighbour, new Cell(neighbour, activeCell, activeCell.distanceToHome + 1, neighbour.calculateDistanceTo(target)));
            return true;
        }
        if (neighbour.fitInMap(map.length, map.height) && !map.map.containsKey(neighbour) && !listMap.containsKey(neighbour)) {
            listMap.put(neighbour, new Cell(neighbour, activeCell, activeCell.distanceToHome + 1, neighbour.calculateDistanceTo(target)));
            counter++;
        }
        if (counter > 0) return true;
        else
            return false;
    }

    public static Cell findBestCellInList(HashMap<Coordinates, Cell> listMap, HashMap<Coordinates, Cell> closedList) {
        minValue = 2147483647;
        listMap.forEach((coordinates, cell) -> {
            if ((cell.distanceToHome + cell.distanceToTarget) < minValue && !(closedList.containsKey(coordinates))) {
                bestCell = cell;
                minValue = cell.distanceToHome + cell.distanceToTarget;
            }
        });
        return bestCell;
    }
}