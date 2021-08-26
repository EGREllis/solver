package net.ellise.sudoku.view.swing;

import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

import javax.swing.*;
import java.awt.*;

public class SwingView implements View {
    private JFrame main;
    private SudokuCanvas canvas;

    public void initialise() {
        main = new JFrame("Sudoku with solver");

        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new BorderLayout());
        canvas = new SudokuCanvas();
        canvas.addMouseListener(canvas.getMouseListener());

        main.add(canvas, BorderLayout.CENTER);
        main.setSize(500,500);
        main.setVisible(true);
        main.pack();
    }

    public void render(Puzzle puzzle) {

    }
}
