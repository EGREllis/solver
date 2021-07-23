package net.ellise.sudoku.model;

import java.util.Map;

public class CompositePuzzle implements Puzzle {
    private final Puzzle puzzle;
    private final Map<Place, Integer> diff;

    public CompositePuzzle(Puzzle puzzle, Map<Place, Integer> diff) {
        this.puzzle = puzzle;
        this.diff = diff;
    }

    @Override
    public int getCellAt(Place place) {
        Integer result = diff.get(place);
        if (result == null) {
            result = puzzle.getCellAt(place);
        }
        return result;
    }
}
