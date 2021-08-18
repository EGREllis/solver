package net.ellise.sudoku.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range implements Iterable<Integer> {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getRange() { return max - min + 1; }

    @Override
    public String toString() {
        return String.format("[%1$d, %2$d]", min, max);
    }

    @Override
    public Iterator<Integer> iterator() {
        List<Integer> list = new ArrayList<>(max - min + 1);
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list.iterator();
    }
}
