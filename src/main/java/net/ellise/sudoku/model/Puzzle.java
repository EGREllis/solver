package net.ellise.sudoku.model;

public interface Puzzle {
    Range WIDTH = new Range(1, 9);
    Range HEIGHT = new Range(1, 9);
    Range DIGITS = new Range(1, 9);
    Area AREA = new Area(WIDTH, HEIGHT);
    int getCellAt(Place place);
}
