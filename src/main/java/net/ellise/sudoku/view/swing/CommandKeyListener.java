package net.ellise.sudoku.view.swing;

import net.ellise.sudoku.model.Command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandKeyListener implements KeyListener {
    private final char key;
    private final Command command;

    public CommandKeyListener(char key, Command command) {
        this.key = key;
        this.command = command;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == key) {
            command.execute();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
