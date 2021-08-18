package net.ellise.sudoku.io;

import net.ellise.sudoku.model.MapPuzzleImpl;
import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public abstract class PuzzleReaderTemplate implements Callable<Puzzle> {
    private final String path;

    public PuzzleReaderTemplate(String path) {
        this.path = path;
    }

    protected abstract void initiateStorage();
    protected abstract void savePlace(Place place, int value);
    protected abstract Puzzle getPuzzle();

    @Override
    public Puzzle call() throws Exception {
        initiateStorage();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(path)))) {
            for (int row : Puzzle.HEIGHT) {
                String line = reader.readLine();
                for (int col : Puzzle.WIDTH) {
                    int value;
                    char c = line.charAt(col-1);
                    switch (c) {
                        case '.':
                            value = 0;
                            break;
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            value = Integer.parseInt(new String(new char[] {c}, 0, 1));
                            break;
                        default:
                            throw new IllegalStateException(String.format("Could not parse sudoku cell (%1$d, %2$d) value %3$s", col, row, line));
                    }
                    Place place = new Place(col, row);
                    savePlace(place, value);
                }
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        return getPuzzle();
    }
}
