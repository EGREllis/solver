package net.ellise.sudoku.view.swing;

import net.ellise.sudoku.model.Command;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class SwingView implements View {
    private JFrame main;
    private SudokuCanvas canvas;

    public void initialise(Map<String, Command> menuCommands) {
        main = new JFrame("Sudoku with solver");

        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new BorderLayout());
        canvas = new SudokuCanvas();
        canvas.addMouseListener(canvas.getMouseListener());
        canvas.setFocusable(true);
        canvas.requestFocus();

        JMenuBar menuBar = initialiseMenuBar(menuCommands);
        main.setJMenuBar(menuBar);

        main.add(canvas, BorderLayout.CENTER);
        main.setSize(500,500);
        main.setVisible(true);
        main.pack();
    }

    public JMenuBar initialiseMenuBar(Map<String,Command> menuCommands) {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem fileNewMenuItem = new JMenuItem("New");
        fileNewMenuItem.setActionCommand("New");
        JMenuItem fileOpenMenuItem = new JMenuItem("Open...");
        fileOpenMenuItem.setActionCommand("Open");
        JMenuItem fileSaveAsMenuItem = new JMenuItem("Save as...");
        fileSaveAsMenuItem.setActionCommand("SaveAs");
        JMenuItem fileExitMenuItem = new JMenuItem("Exit");
        fileExitMenuItem.setActionCommand("Exit");

        fileMenu.add(fileNewMenuItem);
        fileMenu.add(fileOpenMenuItem);
        fileMenu.add(fileSaveAsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(fileExitMenuItem);

        for (Map.Entry<String, Command> entry : menuCommands.entrySet()) {
            ActionListener menuListener = new CommandMenuListener(entry.getKey(), entry.getValue());
            fileNewMenuItem.addActionListener(menuListener);
            fileOpenMenuItem.addActionListener(menuListener);
            fileSaveAsMenuItem.addActionListener(menuListener);
            fileExitMenuItem.addActionListener(menuListener);
        }

        menuBar.add(fileMenu);
        return menuBar;
    }

    @Override
    public Puzzle getPuzzle() {
        return canvas.getPuzzle();
    }

    public void render(Puzzle puzzle) {
        this.canvas.render(puzzle);
    }

    public void addKeyListener(char key, Command command) {
        this.canvas.addKeyListener(new CommandKeyListener(key, command));
    }
}
