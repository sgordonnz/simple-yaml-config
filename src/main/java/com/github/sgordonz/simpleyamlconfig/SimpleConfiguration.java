package com.github.sgordonz.simpleyamlconfig;

import com.github.sgordonz.simpleyamlconfig.loader.ConfigurationSource;
import com.github.sgordonz.simpleyamlconfig.loader.FileSource;
import com.github.sgordonz.simpleyamlconfig.section.ConfigSection;
import com.github.sgordonz.simpleyamlconfig.section.ConfigSectionImpl;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SimpleConfiguration {
    private final ConfigSection root;

    private SimpleConfiguration(final ConfigSection root) {
        this.root = root;
    }

    public boolean get(String path, boolean defaultValue) {
        Object value = root.get(path);
        return value instanceof Boolean ? (boolean) value : defaultValue;
    }

    public int get(String path, int defaultValue) {
        Object value = root.get(path);
        return value instanceof Integer ? (int) value : defaultValue;
    }

    public float get(String path, float defaultValue) {
        Object value = root.get(path);
        return value instanceof Float ? (float) value : defaultValue;
    }

    public String get(String path, String defaultValue) {
        Object value = root.get(path);
        return value instanceof String ? (String) value : defaultValue;
    }

    public static SimpleConfiguration load(File file) throws IOException {
        return load(new FileSource(file));
    }

    public static SimpleConfiguration load(ConfigurationSource source) {
        final Yaml yaml = new Yaml();
        Map<String, ?> loaded = yaml.load(source.reader());
        return new SimpleConfiguration(new ConfigSectionImpl(loaded));
    }
}
