package main.java.kuznetsov.entity;

public abstract class Creature extends Entity{
    public static Coordinates coordinates;
    public void makeMove(){};
    public Coordinates getCoordinates() {
        return coordinates;
    }
}