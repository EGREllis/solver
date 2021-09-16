package net.ellise.sudoku.view;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;

public interface View {
    Puzzle getPuzzle();
    void render(Puzzle puzzle);
    Place getSelected();
}
