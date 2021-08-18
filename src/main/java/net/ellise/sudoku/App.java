package net.ellise.sudoku;

import net.ellise.sudoku.io.MapPuzzleReader;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.cli.CliView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Puzzle puzzle = new MapPuzzleReader("puzzle/1.dat").call();
        System.out.println(new CliView().render(puzzle));
    }
}
