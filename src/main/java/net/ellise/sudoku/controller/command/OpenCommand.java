package net.ellise.sudoku.controller.command;

import net.ellise.sudoku.controller.CommandLineSettings;
import net.ellise.sudoku.io.PuzzleReader;
import net.ellise.sudoku.io.composite.source.FilePathSource;
import net.ellise.sudoku.model.Command;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

import javax.swing.*;
import java.io.File;
import java.util.concurrent.Callable;

public class OpenCommand implements Command {
    private final JFrame dialogMain = new JFrame("Open");
    private final View view;
    private final CommandLineSettings settings;

    public OpenCommand(CommandLineSettings settings, View view) {
        this.view = view;
        this.settings = settings;
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showOpenDialog(dialogMain);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                System.out.println("Selected file is null");
            }
            try {
                Puzzle puzzle = settings.getPuzzleReader(new FilePathSource()).readPuzzle(file.getAbsolutePath());
                view.render(puzzle);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace(System.err);
                System.err.flush();
            }
        } else if (retval == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancelled");
        }
    }
}
