package com.github.sgordonz.simpleyamlconfig.section;

import java.util.regex.Pattern;

public class SectionKey {
    private final String[] path;
    private int index;

    public SectionKey(String path) {
        this.path = path.split(Pattern.quote("."));
    }

    public String get() {
        return index < path.length ? path[index++] : "";
    }
}
