package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;

public class MapConsoleRender {


    public static void render(Map map){
        String stringOut = "";
        for (int i = 0; i < map.height; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map.getEntityByCoordinates(new Coordinates(j,i)) != null){
                    stringOut = stringOut + map.getEntityByCoordinates(new Coordinates(j,i)).getImage();
                    continue;
                }
                stringOut = stringOut + "  ";
            }
            stringOut = stringOut + "\n";
        }
        System.out.println(stringOut);
    }
}