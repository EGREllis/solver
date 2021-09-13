package net.ellise.sudoku.io.composite.source;

import java.io.InputStream;

public interface Source {
    InputStream getSource(String path) throws Exception;
}
