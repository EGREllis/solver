package net.ellise.sudoku.io.composite.source;

import java.io.InputStream;

public class ClasspathSource implements Source {
    @Override
    public InputStream getSource(String path) throws Exception {
        return ClassLoader.getSystemResourceAsStream(path);
    }
}
