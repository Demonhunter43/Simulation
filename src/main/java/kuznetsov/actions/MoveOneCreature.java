package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;

public class MoveOneCreature extends Action{
    public static void move(MapField map, Entity entity, Coordinates nextCoordinates){
        map.map.put(nextCoordinates, entity);
        map.map.remove(entity.getCoordinates());
        entity.setCoordinates(nextCoordinates);
    }
}
