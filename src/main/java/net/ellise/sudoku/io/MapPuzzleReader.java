package net.ellise.sudoku.io;

import net.ellise.sudoku.model.MapPuzzleImpl;
import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

import java.util.HashMap;
import java.util.Map;

public class MapPuzzleReader extends PuzzleReaderTemplate {
    private Map<Place,Integer> data;

    public MapPuzzleReader(String path) {
        super(path);
    }

    @Override
    protected void initiateStorage() {
        data = new HashMap<>();
    }

    @Override
    protected void savePlace(Place place, int value) {
        data.put(place, value);
    }

    @Override
    protected Puzzle getPuzzle() {
        return new MapPuzzleImpl(data);
    }
}
