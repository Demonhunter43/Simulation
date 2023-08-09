package main.java.kuznetsov.entity;

public class Tree extends Item {
    private String image = "\uD83C\uDF44";
            ;
    private Coordinates coordinates;

    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getImage() {
        return image;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
}