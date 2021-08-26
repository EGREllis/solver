package net.ellise.sudoku.view.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SudokuCanvas extends Canvas {
    private static final Color BLACK = new Color(0,0,0);

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(BLACK);
        drawLines(g);
    }

    private void drawLines(Graphics g) {
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

    public MouseListener getMouseListener() {
        return new SudokuCanvasMouseListener();
    }

    public class SudokuCanvasMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int cellWidth = SudokuCanvas.this.getWidth() / 9;
            int cellHeight = SudokuCanvas.this.getHeight() / 9;
            int cellX = e.getX() / cellWidth;
            int cellY = e.getY() / cellHeight;
            System.out.println(String.format("Clicked (%1$d,%2$d) cell (%3$d,%4$d)", e.getX(), e.getY(), cellX, cellY));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // Do nothing
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Do nothing
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Do nothing
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Do nothing
        }
    }
}
