package net.ellise.sudoku.io;

import net.ellise.sudoku.model.ArrayPuzzleImpl;
import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

public class ArrayPuzzleReader extends PuzzleReaderTemplate {
    private int[][] data;

    public ArrayPuzzleReader(String path) {
        super(path);
    }

    @Override
    protected void initiateStorage() {
        data = new int[Puzzle.HEIGHT.getMax()][];
        for (int i = 0; i < Puzzle.HEIGHT.getMax(); i++) {
            data[i] = new int[Puzzle.WIDTH.getMax()];
        }
    }

    @Override
    protected void savePlace(Place place, int value) {
        Place offset = offset(place);
        data[offset.getY()][offset.getX()] = value;
    }

    @Override
    protected Puzzle getPuzzle() {
        return new ArrayPuzzleImpl(data);
    }

    private Place offset(Place place) {
        return new Place(place.getX()-1, place.getY()-1);
    }
}
