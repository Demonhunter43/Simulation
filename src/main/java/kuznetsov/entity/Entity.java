package main.java.kuznetsov.entity;

public abstract class Entity {
    private Coordinates coordinates;
    private String image;

    public String getImage() {
        return image;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}