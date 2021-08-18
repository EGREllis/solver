package net.ellise.sudoku.model;

public class ArrayPuzzleImpl implements Puzzle {
    private final int[][] data;

    public ArrayPuzzleImpl(int[][] data) {
        this.data = data;
    }

    @Override
    public int getCellAt(Place place) {
        return data[place.getY()][place.getX()];
    }
}
