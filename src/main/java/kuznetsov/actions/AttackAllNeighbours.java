package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.*;

import java.util.Set;

public class AttackAllNeighbours extends Action {
    int herbivoreDeathCounter;

    public int doAction(MapField map) {
        herbivoreDeathCounter = 0;
        Set setOfCoordinates = map.map.keySet();
        for (Object currentCoordinates : setOfCoordinates) {
            AttackNeighbours(map, (Coordinates) currentCoordinates);
        }
        return herbivoreDeathCounter;
    }

    private void AttackNeighbours(MapField map, Coordinates currentCoordinates) {
        herbivoreDeathCounter = 0;
        boolean attackFlag = false;
        Coordinates coordinatesToCheck;
        Entity entity;
        if (map.map.containsKey(currentCoordinates)) {
            entity = map.getEntityByCoordinates(currentCoordinates);
        } else {
            entity = new Grass();
        }
        if (entity.getClass() == Herbivore.class) {
            coordinatesToCheck = new Coordinates(currentCoordinates.getX(), currentCoordinates.getY() + 1);
            if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                    map.map.remove(coordinatesToCheck);
                    attackFlag = true;
                }
            }
            coordinatesToCheck = new Coordinates(currentCoordinates.getX(), currentCoordinates.getY() - 1);
            if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                    map.map.remove(coordinatesToCheck);
                    attackFlag = true;
                }
            }
            coordinatesToCheck = new Coordinates(currentCoordinates.getX() + 1, currentCoordinates.getY());
            if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                    map.map.remove(coordinatesToCheck);
                    attackFlag = true;
                }
            }
            coordinatesToCheck = new Coordinates(currentCoordinates.getX() - 1, currentCoordinates.getY());
            if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                    map.map.remove(coordinatesToCheck);
                    attackFlag = true;
                }
            }
        }

        if (entity.getClass() == Predator.class) {
            coordinatesToCheck = new Coordinates(currentCoordinates.getX(), currentCoordinates.getY() + 1);
            if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                    map.map.remove(coordinatesToCheck);
                    herbivoreDeathCounter++;
                    attackFlag = true;
                }
            }
            coordinatesToCheck = new Coordinates(currentCoordinates.getX(), currentCoordinates.getY() - 1);
            if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                    map.map.remove(coordinatesToCheck);
                    herbivoreDeathCounter++;
                    attackFlag = true;
                }
            }
            coordinatesToCheck = new Coordinates(currentCoordinates.getX() + 1, currentCoordinates.getY());
            if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                    map.map.remove(coordinatesToCheck);
                    herbivoreDeathCounter++;
                    attackFlag = true;
                }
            }
            coordinatesToCheck = new Coordinates(currentCoordinates.getX() - 1, currentCoordinates.getY());
            if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                    map.map.remove(coordinatesToCheck);
                    herbivoreDeathCounter++;
                }
            }
        }
    }
}
