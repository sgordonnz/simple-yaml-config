package com.github.sgordonz.simpleyamlconfig.section;

public class ConfigValue implements ConfigSection {
    private final Object value;
    public ConfigValue(final Object value) {
        this.value = value;
    }

    @Override
    public Object get(String path) {
        return value;
    }

    @Override
    public Object get(SectionKey path) {
        return value;
    }
}
