package main.java.kuznetsov.entity;

public class Rock extends Item {
    static String image = "⛰\uFE0F";
    private Coordinates coordinates;

    public Rock(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getImage() {
        return image;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
