package com.github.sgordonz.simpleyamlconfig.section;

public interface ConfigSection {
    Object get(String path);
    Object get(SectionKey path);
}
