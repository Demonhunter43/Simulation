package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.PathFinder;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Herbivore;
import main.java.kuznetsov.entity.Predator;

public class MoveAllCreatures extends Action{
    private PathFinder pathFinder;
    private MoveOneCreature mover;
    public void doAction(MapField map){
        map.map.forEach((coordinates, entity) -> {
            if ((entity.getClass() == Herbivore.class) || ((entity.getClass() == Predator.class))){
                pathFinder = new PathFinder();
                Coordinates nextCoordinates = pathFinder.findNextCell(entity, map);
                mover.move(map, entity, nextCoordinates);
            }
        });

    }
}
