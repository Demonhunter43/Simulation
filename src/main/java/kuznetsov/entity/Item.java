package main.java.kuznetsov.entity;

public abstract class Item extends Entity{
    public static Coordinates coordinates;
    public Coordinates getCoordinates() {
        return coordinates;
    }
}