package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;

public class Cell{
    public Coordinates coordinates;
    public Cell home;
    public int distanceToHome, distanceToTarget;
    public Cell(Coordinates coordinates, Cell home, int distanceToHome, int distanceToTarget) {
        this.coordinates = coordinates;
        this.home = home;
        this.distanceToHome = distanceToHome;
        this.distanceToTarget = distanceToTarget;
    }
}