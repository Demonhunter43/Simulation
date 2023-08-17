package main.java.kuznetsov.actions;

import main.java.kuznetsov.MapField;
import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;

public class MoveOneCreature extends Action {
    public static int move(MapField map, Entity entity, Coordinates nextCoordinates) {
        if (entity.getCoordinates().getDistanceTo(nextCoordinates) != 1) {
            System.out.println("Ало! Проблема с координатами!");
        }
        Coordinates currentCoordinates = entity.getCoordinates();
        entity.setCoordinates(nextCoordinates);
        map.map.put(nextCoordinates, entity);
        map.map.remove(currentCoordinates);
        return 1;
    }
}
