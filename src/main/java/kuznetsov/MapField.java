package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;
import main.java.kuznetsov.entity.Entity;
import main.java.kuznetsov.entity.Herbivore;

import java.util.HashMap;

public class MapField {
    public HashMap<Coordinates, Entity> map;
    public int height, length;

    public MapField(int height, int length){
        map = new HashMap<Coordinates, Entity>();
        this.height = height;
        this.length = length;
    }

    public void put(Coordinates coordinates, Entity entity){
        this.map.put(coordinates, entity);
    }
    public Entity getEntityByCoordinates(Coordinates coordinates){
        return map.get(coordinates);
    }
    public boolean containsValue(Herbivore herbivore){
        return map.containsValue(herbivore);
    }
}