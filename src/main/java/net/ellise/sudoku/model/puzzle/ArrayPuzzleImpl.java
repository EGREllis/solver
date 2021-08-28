package net.ellise.sudoku.model.puzzle;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

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

    @Override
    public Puzzle deepCopy() {
        int [][] newData = new int[data.length][];
        for (int i = 0; i < data.length; i++) {
            newData[i] = new int[data[i].length];
        }
        for (int y = 0; y < newData.length; y++) {
            for (int x = 0; x < newData[y].length; x++) {
                newData[y][x] = data[y][x];
            }
        }
        return new ArrayPuzzleImpl(newData);
    }

    private Place offset(Place place) {
        return new Place(place.getX()-1, place.getY()-1);
    }
}
