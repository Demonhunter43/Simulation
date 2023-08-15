package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.PathFinder;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Herbivore;
import main.java.kuznetsov.entity.Predator;

import java.util.Set;

public class MoveAllCreatures extends Action {
    private PathFinder pathFinder;
    private MoveOneCreature mover;

    public int doAction(MapField map) {
        Set setOfCoordinates = map.map.keySet();
        for (Object currentCoordinates : setOfCoordinates) {
            Entity entity = map.getEntityByCoordinates((Coordinates) currentCoordinates);
            if ((entity.getClass() == Herbivore.class) || ((entity.getClass() == Predator.class))) {
                pathFinder = new PathFinder();
                Coordinates nextCoordinates = pathFinder.findNextCoordinates(entity, map);
                mover.move(map, entity, nextCoordinates);
            }
        }
        return 1;
    }
}
