package com.github.sgordonz.simpleyamlconfig.loader;

import java.io.Reader;

public interface ConfigurationSource extends AutoCloseable {
    Reader reader();
}
