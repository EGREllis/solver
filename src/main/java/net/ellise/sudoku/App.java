package net.ellise.sudoku;

import net.ellise.sudoku.io.ArrayPuzzleReader;
import net.ellise.sudoku.io.MapPuzzleReader;
import net.ellise.sudoku.solver.BacktrackingSolver;
import net.ellise.sudoku.model.Puzzle;
import net.ellise.sudoku.view.cli.CliView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        String path = "puzzle/1.dat";
        CliView view = new CliView();

        Puzzle mapPuzzle = new MapPuzzleReader(path).call();
        System.out.println(view.render(mapPuzzle));

        Puzzle arrayPuzzle = new ArrayPuzzleReader(path).call();
        System.out.println(view.render(arrayPuzzle));

        BacktrackingSolver solver = new BacktrackingSolver();
        if (solver.solve(arrayPuzzle)) {
            System.out.println("Has been solved:");
            System.out.println(view.render(arrayPuzzle));
        } else {
            System.out.println("Has not been solved:");
            System.out.println(view.render(arrayPuzzle));
        }
    }
}
