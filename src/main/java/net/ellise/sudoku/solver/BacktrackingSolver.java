package net.ellise.sudoku.solver;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

public class BacktrackingSolver {

    public boolean solve(Puzzle puzzle) {
        Place startPlace = findNextBlank(puzzle);
        for (int newValue : Puzzle.DIGITS) {
            if (solve(puzzle, startPlace, newValue)) {
                return true;
            }
        }
        return false;
    }

    public boolean solve(Puzzle puzzle, Place place, int value) {
        puzzle.setCellAt(place, value);
        if (isValid(puzzle, place, value)) {
            Place nextPlace = findNextBlank(puzzle);
            if (nextPlace == null) {
                return true;
            }
            for (int newValue : Puzzle.DIGITS) {
                if (solve(puzzle, nextPlace, newValue)) {
                    return true;
                }
            }
        }
        puzzle.setCellAt(place, 0);
        return false;
    }

    private boolean isValid(Puzzle puzzle, Place place, int value) {
        // Valid row
        for (int row : Puzzle.HEIGHT) {
            if (row != place.getY() && puzzle.getCellAt(new Place(place.getX(), row)) == value) {
                return false;
            }
        }
        // Valid column
        for (int col : Puzzle.WIDTH) {
            if (col != place.getX() && puzzle.getCellAt(new Place(col, place.getY())) == value) {
                return false;
            }
        }
        // Valid square
        int squareX = (place.getX()-1) / 3;
        int squareY = (place.getY()-1) / 3;
        for (int sy = squareY * 3 + 1; sy < squareY * 3 + 4; sy++) {
            for (int sx = squareX * 3 + 1; sx < squareX * 3 + 4; sx++) {
                if ( (place.getX() != sx || place.getY() != sy) /* False only on the spot */
                    && puzzle.getCellAt(new Place(sx, sy)) == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private Place findNextBlank(Puzzle puzzle) {
        Place result = null;
        for (Place place : Puzzle.AREA) {
            if (puzzle.getCellAt(place) == 0) {
                result = place;
                break;
            }
        }
        return result;
    }
}
