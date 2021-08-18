package net.ellise.sudoku.model;

public class ArrayPuzzleImpl implements Puzzle {
    private final int[][] data;

    public ArrayPuzzleImpl(int[][] data) {
        this.data = data;
    }

    @Override
    public int getCellAt(Place place) {
        Place offset = offset(place);
        return data[offset.getY()][offset.getX()];
    }

    @Override
    public void setCellAt(Place place, int value) {
        Place offset = offset(place);
        data[offset.getY()][offset.getX()] = value;
    }

    private Place offset(Place place) {
        return new Place(place.getX()-1, place.getY()-1);
    }
}
