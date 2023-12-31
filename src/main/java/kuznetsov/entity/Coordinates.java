package main.java.kuznetsov.entity;

import main.java.kuznetsov.MapField;

import java.util.Objects;

public class Coordinates extends Object{
    private int x,y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    public int getDistanceTo(Coordinates coordinates){
        return Math.abs((this.x - coordinates.getX())) + Math.abs(this.y - coordinates.getY());
    }

    public boolean fitInMap(MapField map) {
        return this.x < map.length && this.x > -1 && this.y < map.height && this.y > -1;
    }
}