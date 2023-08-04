package main.java.kuznetsov.entity;

public class Predator extends Creature {
    private String image = "🦁";
    private Coordinates coordinates;

    public Predator(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getImage() {
        return image;
    }
}
