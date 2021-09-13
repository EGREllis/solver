package net.ellise.sudoku.io.composite.source;

import java.io.FileInputStream;
import java.io.InputStream;

public class FilePathSource implements Source {
    @Override
    public InputStream getSource(String path) throws Exception {
        return new FileInputStream(path);
    }
}
