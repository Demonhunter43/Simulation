package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Grass;
import main.java.kuznetsov.entity.Herbivore;
import main.java.kuznetsov.entity.Predator;

public class AttackAllNeighbours extends Action {
    public Coordinates coordinatesToCheck;
    int herbivoreDeathCounter;
    boolean attackFlag;

    public int doAction(MapField map) {
        herbivoreDeathCounter = 0;
        map.map.forEach((coordinates, entity) -> {
            attackFlag = false;
            if (entity.getClass() == Herbivore.class) {
                coordinatesToCheck = new Coordinates(coordinates.getX() + 1, coordinates.getY());
                if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                    if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                        map.map.remove(coordinatesToCheck);
                        attackFlag = true;
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX() - 1, coordinates.getY());
                if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                    if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                        map.map.remove(coordinatesToCheck);
                        attackFlag = true;
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
                if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                    if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                        map.map.remove(coordinatesToCheck);
                        attackFlag = true;
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
                if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                    if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                        map.map.remove(coordinatesToCheck);
                        attackFlag = true;
                    }
                }
            }
            if (entity.getClass() == Predator.class) {
                coordinatesToCheck = new Coordinates(coordinates.getX() + 1, coordinates.getY());
                if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                    if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                        map.map.remove(coordinatesToCheck);
                        herbivoreDeathCounter++;
                        attackFlag = true;
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX() - 1, coordinates.getY());
                if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                    if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                        map.map.remove(coordinatesToCheck);
                        herbivoreDeathCounter++;
                        attackFlag = true;
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
                if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                    if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                        map.map.remove(coordinatesToCheck);
                        herbivoreDeathCounter++;
                        attackFlag = true;
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
                if (map.map.containsKey(coordinatesToCheck) && !attackFlag) {
                    if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                        map.map.remove(coordinatesToCheck);
                        herbivoreDeathCounter++;
                        attackFlag = true;
                    }
                }
            }
        });
        return herbivoreDeathCounter;
    }
}
