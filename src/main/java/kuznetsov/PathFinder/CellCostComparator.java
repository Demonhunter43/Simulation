package main.java.kuznetsov.PathFinder;

import java.util.Comparator;

public class CellCostComparator implements Comparator<Cell> {
    @Override
    public int compare(Cell firstCell, Cell secondCell) {
        if (firstCell.getCost() < secondCell.getCost()) {
            return -1;
        }
        if (firstCell.getCost() > secondCell.getCost()) {
            return 1;
        }
        return 0;
    }
}