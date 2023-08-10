package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Grass;
import main.java.kuznetsov.entity.Herbivore;
import main.java.kuznetsov.entity.Predator;

public class AttackAllNeighbours extends Action {
    public Coordinates coordinatesToCheck;

    public void doAction(MapField map) {
        map.map.forEach((coordinates, entity) -> {
            if (entity.getClass() == Herbivore.class) {
                coordinatesToCheck = new Coordinates(coordinates.getX() + 1, coordinates.getY());
                if (map.map.containsKey(coordinatesToCheck)) {
                    if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                        map.map.remove(coordinatesToCheck);
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX() - 1, coordinates.getY());
                if (map.map.containsKey(coordinatesToCheck)) {
                    if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                        map.map.remove(coordinatesToCheck);
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
                if (map.map.containsKey(coordinatesToCheck)) {
                    if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                        map.map.remove(coordinatesToCheck);
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
                if (map.map.containsKey(coordinatesToCheck)) {
                    if (map.map.get(coordinatesToCheck).getClass() == Grass.class) {
                        map.map.remove(coordinatesToCheck);
                    }
                }
            }
            if (entity.getClass() == Predator.class) {
                coordinatesToCheck = new Coordinates(coordinates.getX() + 1, coordinates.getY());
                if (map.map.containsKey(coordinatesToCheck)) {
                    if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                        map.map.remove(coordinatesToCheck);
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX() - 1, coordinates.getY());
                if (map.map.containsKey(coordinatesToCheck)) {
                    if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                        map.map.remove(coordinatesToCheck);
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
                if (map.map.containsKey(coordinatesToCheck)) {
                    if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                        map.map.remove(coordinatesToCheck);
                    }
                }
                coordinatesToCheck = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
                if (map.map.containsKey(coordinatesToCheck)) {
                    if (map.map.get(coordinatesToCheck).getClass() == Herbivore.class) {
                        map.map.remove(coordinatesToCheck);
                    }
                }
            }
        });
    }
}
