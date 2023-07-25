import entity.Coordinates;
import entity.Entity;

import java.util.HashMap;

public class Map {
    private HashMap<Coordinates, Entity> Map;

    public HashMap<Coordinates, Entity> makeNewMap(int length, int height){
        return new HashMap<>();
    }
}
