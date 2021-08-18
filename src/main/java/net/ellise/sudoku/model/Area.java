package net.ellise.sudoku.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Area implements Iterable<Place> {
    private final Range horizontal;
    private final Range vertical;

    public Area(Range horizontal, Range vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    @Override
    public Iterator<Place> iterator() {
        List<Place> places = new ArrayList<>(horizontal.getRange() * vertical.getRange());
        for (Integer row : vertical) {
            for (Integer col : horizontal) {
                Place place = new Place(col, row);
                places.add(place);
            }
        }
        return places.iterator();
    }
}
