package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.PathFinder.PathFinder;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Herbivore;
import main.java.kuznetsov.entity.Predator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MoveAllCreatures extends Action {
    private PathFinder pathFinder;
    private MoveOneCreature mover;

    public int doAction(MapField map) { // Make array with changes, then use it in the next loop
        Set setOfCoordinates = map.map.keySet();
        ArrayList<Change> changes = new ArrayList<>();
        for (Object currentCoordinates : setOfCoordinates) {
            Entity entity = map.getEntityByCoordinates((Coordinates) currentCoordinates);
            if ((entity.getClass() == Herbivore.class) || ((entity.getClass() == Predator.class))) {
                pathFinder = new PathFinder();
                Coordinates nextCoordinates = pathFinder.findNextCoordinates(entity, map);
                changes.add(new Change(entity, nextCoordinates));
            }
        }
        mover = new MoveOneCreature();
        for (Change change :
                changes) {
            mover.move(map, change.entity, change.nextCoordinates);
        }
        return 1;
    }

    public class Change {
        Entity entity;
        Coordinates nextCoordinates;

        public Change(Entity entity, Coordinates nextCoordinates) {
            this.entity = entity;
            this.nextCoordinates = nextCoordinates;
        }
    }
}
