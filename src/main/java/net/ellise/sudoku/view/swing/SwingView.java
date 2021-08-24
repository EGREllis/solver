package net.ellise.sudoku.view.swing;

import net.ellise.sudoku.model.Puzzle;

import javax.swing.*;
import java.awt.*;

public class SwingView {
    private JFrame main;
    private SudokuCanvas canvas;

    public void initialise() {
        main = new JFrame("Sudoku with solver");
        main.setLayout(new BorderLayout());
        canvas = new SudokuCanvas();
        main.add(canvas, BorderLayout.CENTER);

        main.setVisible(true);
        main.pack();
    }

    public void render(Puzzle puzzle) {

    }
}
