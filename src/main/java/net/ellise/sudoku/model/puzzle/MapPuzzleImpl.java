package net.ellise.sudoku.model.puzzle;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

import java.util.Iterator;
import java.util.Map;

public class MapPuzzleImpl implements Puzzle, Iterable<Place> {
    private Map<Place, Integer> map;

    public MapPuzzleImpl(Map<Place,Integer> map) {
        this.map = map;
    }

    public int getCellAt(Place place) {
        Integer result = map.get(place);
        return (result == null ? 0 : result);
    }

    @Override
    public void setCellAt(Place place, int value) {
        map.put(place, value);
    }

    @Override
    public Iterator<Place> iterator() {
        return AREA.iterator();
    }
}
