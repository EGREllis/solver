package net.ellise.sudoku.model;

import java.util.Map;

public class PuzzleImpl implements Puzzle {
    private Map<Place, Integer> map;

    public PuzzleImpl(Map<Place,Integer> map) {
        this.map = map;
    }

    public int getCellAt(Place place) {
        Integer result = map.get(place);
        return (result == null ? 0 : result);
    }
}
