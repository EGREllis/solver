package net.ellise.sudoku.io;

import net.ellise.sudoku.model.Puzzle;

public interface PuzzleReader {
    Puzzle readPuzzle(String path) throws Exception;
}
