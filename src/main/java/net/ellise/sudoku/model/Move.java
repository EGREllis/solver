package net.ellise.sudoku.model;

public class Move {
    private final Place place;
    private final int value;

    public Move(Place place, int value) {
        this.place = place;
        this.value = value;
    }

    public Place getPlace() {
        return place;
    }

    public int getValue() {
        return value;
    }
}
