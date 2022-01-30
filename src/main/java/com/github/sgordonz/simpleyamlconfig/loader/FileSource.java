package com.github.sgordonz.simpleyamlconfig.loader;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;

public class FileSource implements ConfigurationSource {
    private final File file;
    private final Reader reader;

    public FileSource(final File file) throws IOException {
        this.file = file;
        this.reader = Files.newBufferedReader(file.toPath());
    }

    @Override
    public Reader reader() {
        return reader;
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
