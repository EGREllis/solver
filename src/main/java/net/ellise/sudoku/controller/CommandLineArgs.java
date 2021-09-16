package net.ellise.sudoku.controller;

public class CommandLineArgs {
    private static final String USAGE = "Command line options:\n\t-p\tpath\n\t-s\tstorage\nThe -p options allows one to specify the path of the .dat file to be solved.\nThe -s option allows one to choose between array or map implementation.\n";
    private final String puzzlePath;
    private final boolean isArrayBased;

    private CommandLineArgs(String puzzlePath, boolean isArrayBased) {
        this.puzzlePath = puzzlePath;
        this.isArrayBased = isArrayBased;
    }

    public String getPuzzlePath() {
        return puzzlePath;
    }

    public boolean isArrayBased() {
        return isArrayBased;
    }

    public static CommandLineArgs parse(String args[]) {
        String puzzlePath = "puzzle/1.dat";
        boolean isArrayBased = true;

        for (int i = 0; i < args.length; i++) {
            switch(args[i]) {
                case "-p":
                    puzzlePath = args[++i];
                    break;
                case "-s":
                    if (args[++i].toLowerCase().startsWith("map")) {
                        isArrayBased = false;
                    } else {
                        isArrayBased = true;
                    }
                    break;
                default:
                    System.out.println(USAGE);
                    break;
            }
        }
        return new CommandLineArgs(puzzlePath, isArrayBased);
    }
}
