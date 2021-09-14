package net.ellise.sudoku.io;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PuzzleWriter {
    public void writePuzzle(String path, Puzzle puzzle) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (int y : Puzzle.HEIGHT) {
                for (int x : Puzzle.WIDTH) {
                    int value = puzzle.getCellAt(new Place(x, y));
                    String cell;
                    switch (value) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            cell = Integer.toString(value);
                            break;
                        case 0:
                            cell = ".";
                            break;
                        default:
                            throw new IllegalStateException("A valid sudoku can only contain the digits 0-9 with 0 representing blanks.");
                    }
                    writer.print(cell);
                }
                writer.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
            System.err.flush();
        }
    }
}
