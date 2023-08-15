package main.java.kuznetsov.PathFinder;

import main.java.kuznetsov.entity.Coordinates;

public class Cell implements Comparable<Cell>{
    public Coordinates coordinates;
    public Cell home;
    public int distanceToHome, distanceToTarget;
    private int cost;

    public Cell(Coordinates coordinates, int distanceToHome, int distanceToTarget, int cost,  Cell home) {
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
    public void setCost(int cost){
        this.cost = cost;
    }

    @Override
    public int compareTo(Cell o) {
        return o.cost > this.cost ? 1 : -1;
    }
}