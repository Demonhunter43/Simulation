package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;

import java.util.concurrent.ConcurrentHashMap;

public class MapField {
    public ConcurrentHashMap<Coordinates, Entity> map;
    public int height, length;

    public MapField(int height, int length) {
        map = new ConcurrentHashMap<Coordinates, Entity>();
        this.height = height;
        this.length = length;
    }

    public Entity getEntityByCoordinates(Coordinates coordinates) {
        return map.get(coordinates);
    }
}