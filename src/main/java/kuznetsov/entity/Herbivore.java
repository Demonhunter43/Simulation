package main.java.kuznetsov.entity;


public class Herbivore extends Creature {
    private Coordinates coordinates;
    static String image = "\uD83D\uDC04";

    public Herbivore(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getImage() {
        return image;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Herbivore() {
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}