package net.ellise.sudoku.model;

public class Place {
    private final int x;
    private final int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%1$d, %2$d)", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Place) {
            Place other = (Place)obj;
            result = x == other.x && y == other.y;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(x) * 13 + Integer.hashCode(y);
    }
}
