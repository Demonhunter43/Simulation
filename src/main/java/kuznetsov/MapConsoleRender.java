package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;

public class MapConsoleRender {


    public static void render(MapField map){
        StringBuilder stringOut = makeHorizontalLaneByLength(map.length);
        stringOut.append("\uD83D\uDFEA");
        for (int i = 0; i < map.height; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map.getEntityByCoordinates(new Coordinates(j,i)) != null){
                    stringOut.append(map.getEntityByCoordinates(new Coordinates(j,i)).getImage());
                    continue;
                }
                stringOut.append("\uD83D\uDFEB");
            }
            stringOut.append("\uD83D\uDFEA\n\uD83D\uDFEA");
        }
        stringOut.append(makeHorizontalLaneByLength(map.length-1));
        System.out.print(stringOut);
    }

    private static StringBuilder makeHorizontalLaneByLength(int length) {
        StringBuilder stringOut = new StringBuilder(new String(""));
        for (int i = 0; i < length + 2; i++) {
            stringOut = stringOut.append("\uD83D\uDFEA");
        }
        return stringOut.append("\n");
    }
}