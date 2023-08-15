package main.java.kuznetsov;

import main.java.kuznetsov.entity.Coordinates;

public class Cell {
    public Coordinates coordinates;
    public Cell home;
    public int distanceToHome, distanceToTarget;
    private int cost;

    public Cell(Coordinates coordinates, Cell home, int distanceToHome, int distanceToTarget, int cost) {
        this.coordinates = coordinates;
        this.home = home;
        this.distanceToHome = distanceToHome;
        this.distanceToTarget = distanceToTarget;
        this.cost = distanceToHome + distanceToTarget;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell that = (Cell) obj;
        return coordinates == that.coordinates;
    }

    public int getCost(){
        return cost;
    }
    public void setCost(){
        this.cost = distanceToHome + distanceToTarget;
    }
}