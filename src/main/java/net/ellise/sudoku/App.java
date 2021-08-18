package net.ellise.sudoku;

import net.ellise.sudoku.io.ArrayPuzzleReader;
import net.ellise.sudoku.io.MapPuzzleReader;
import net.ellise.sudoku.model.ArrayPuzzleImpl;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.cli.CliView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Puzzle mapPuzzle = new MapPuzzleReader("puzzle/1.dat").call();
        System.out.println(new CliView().render(mapPuzzle));
        System.out.println();
        Puzzle arrayPuzzle = new ArrayPuzzleReader("puzzle/1.dat").call();
        System.out.println(new CliView().render(arrayPuzzle));
    }
}
