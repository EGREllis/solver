package net.ellise.sudoku.model;

public interface Puzzle {
    Range WIDTH = new Range(1, 9);
    Range HEIGHT = new Range(1, 9);
    int getCellAt(Place place);
}
