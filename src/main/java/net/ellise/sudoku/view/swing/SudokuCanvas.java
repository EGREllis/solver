package net.ellise.sudoku.view.swing;

import net.ellise.sudoku.model.Place;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SudokuCanvas extends Canvas implements View {
    private static final Color GREEN = new Color(0,255,0);
    private static final Color BLACK = new Color(0,0,0);
    private volatile Puzzle puzzle;
    private volatile Place place;
    private int cellWidth;
    private int cellHeight;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        cellWidth = getWidth() / 9;
        cellHeight = getHeight() / 9;

        if (place != null) {
            g.setColor(GREEN);
            drawSelectedPlace(g);
        }
        g.setColor(BLACK);
        drawLines(g);
        if (puzzle != null) {
            drawPuzzle(g);
        }
    }

    private void drawLines(Graphics g) {
        for (int i = 0; i < 9; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
            if (i % 3 == 0) {
                g.drawLine(0, y+1, getWidth(), y+1);
                g.drawLine(0, y-1, getWidth(), y-1);
            }
        }
        for (int i = 0; i < 9; i ++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
            if (i % 3 == 0) {
                g.drawLine(x+1, 0, x+1, getHeight());
                g.drawLine(x-1, 0, x-1, getHeight());
            }
        }
    }

    private void drawSelectedPlace(Graphics g) {
        if (place != null) {
            g.fillRect(place.getX() * cellWidth, place.getY() * cellHeight, cellWidth, cellHeight);
        }
    }

    private void drawPuzzle(Graphics g) {
        if (puzzle != null) {
            for (Place place : Puzzle.AREA) {
                Place offset = new Place(place.getX() - 1, place.getY());
                int value = puzzle.getCellAt(place);
                if (value != 0) {
                    Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
                    g.setFont(font);
                    int drawX = (int)(offset.getX() * cellWidth + (0.40 * cellWidth));
                    int drawY = (int)(offset.getY() * cellHeight - (0.25 * cellHeight));
                    g.drawString(Integer.toString(value), drawX, drawY);
                }
            }
        }
    }

    public Puzzle getPuzzle() {
        return puzzle.deepCopy();
    }

    public MouseListener getMouseListener() {
        return new SudokuCanvasMouseListener();
    }

    @Override
    public void render(Puzzle puzzle) {
        this.puzzle = puzzle;
        update();
    }

    public void update() {
        try {
            if (SwingUtilities.isEventDispatchThread()) {
                SudokuCanvas.this.repaint();
            } else {
                SwingUtilities.invokeAndWait(new Runnable() {
                    @Override
                    public void run() {
                        SudokuCanvas.this.repaint();
                    }
                });
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
            System.err.flush();
        }
    }

    public class SudokuCanvasMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            int cellWidth = SudokuCanvas.this.getWidth() / 9;
            int cellHeight = SudokuCanvas.this.getHeight() / 9;
            int cellX = e.getX() / cellWidth;
            int cellY = e.getY() / cellHeight;
            System.out.println(String.format("Clicked (%1$d,%2$d) cell (%3$d,%4$d)", e.getX(), e.getY(), cellX, cellY));
            SudokuCanvas.this.place = new Place(cellX, cellY);
            SudokuCanvas.this.repaint();
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
