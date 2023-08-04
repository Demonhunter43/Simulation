package main.java.kuznetsov.entity;

public class Tree extends Item {
    private String image = "🌲";
    private Coordinates coordinates;

    public Tree(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getImage() {
        return image;
    }
}