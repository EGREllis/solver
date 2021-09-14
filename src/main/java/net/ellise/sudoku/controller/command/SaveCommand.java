package net.ellise.sudoku.controller.command;

import net.ellise.sudoku.controller.CommandLineSettings;
import net.ellise.sudoku.io.PuzzleWriter;
import net.ellise.sudoku.io.composite.source.FilePathSource;
import net.ellise.sudoku.model.Command;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

import javax.swing.*;
import java.io.File;

public class SaveCommand implements Command {
    private final JFrame dialogMain = new JFrame("Save as");
    private final CommandLineSettings settings;
    private final View view;

    public SaveCommand(CommandLineSettings settings, View view) {
        this.settings = settings;
        this.view = view;
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser(".");
        int retval = fileChooser.showSaveDialog(dialogMain);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                if (file != null) {
                    Puzzle puzzle = view.getPuzzle();
                    PuzzleWriter writer = settings.getPuzzleWriter();
                    writer.writePuzzle(file.getAbsolutePath(), puzzle);
                } else {
                    System.out.println("Selected file is null");
                }
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
