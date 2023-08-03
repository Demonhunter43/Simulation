package main.java.kuznetsov.entity;

public class Grass extends Item {
    private Coordinates coordinates;
    static String image = "\uD83C\uDF40";

    public Grass(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getImage() {
        return image;
    }
}
