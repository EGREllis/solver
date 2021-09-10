package net.ellise.sudoku.view.swing;

import net.ellise.sudoku.model.Command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandMenuListener implements ActionListener {
    private final String menuCommand;
    private final Command command;

    public CommandMenuListener(String menuCommand, Command command) {
        this.menuCommand = menuCommand;
        this.command = command;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(menuCommand)) {
            command.execute();
        }
    }
}
