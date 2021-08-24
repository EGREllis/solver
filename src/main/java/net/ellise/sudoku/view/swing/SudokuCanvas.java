package net.ellise.sudoku.view.swing;

import java.awt.*;

public class SudokuCanvas extends Canvas {
    private static final Color BLACK = new Color(0,0,0);

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(BLACK);
        for (int i = 0; i < 9; i++) {
            int y = i * getHeight() / 9;
            g.drawLine(0, y, getWidth(), y);
            if (i % 3 == 0) {
                g.drawLine(0, y+1, getWidth(), y+1);
            }
        }
        for (int i = 0; i < 9; i ++) {
            int x = i * getWidth() / 9;
            g.drawLine(x, 0, x, getHeight());
            if (i % 3 == 0) {
                g.drawLine(x+1, 0, x+1, getHeight());
            }
        }
    }
}
