package net.ellise.sudoku.controller;

import net.ellise.sudoku.io.ArrayPuzzleReader;
import net.ellise.sudoku.io.MapPuzzleReader;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;
import net.ellise.sudoku.view.cli.CliView;
import net.ellise.sudoku.view.swing.SwingView;

import java.util.concurrent.Callable;

public class CommandLineSettings {
    private final CommandLineArgs args;

    public CommandLineSettings(CommandLineArgs args) {
        this.args = args;
    }

    public Callable<Puzzle> getParser(String path) {
        if (args.isArrayBased()) {
            return new ArrayPuzzleReader(path);
        } else {
            return new MapPuzzleReader(path);
        }
    }

    public View getView() {
        if (args.isTerminalBased()) {
            return new CliView(System.out);
        } else {
            SwingView view = new SwingView();
            view.initialise();
            return view;
        }
    }
}
