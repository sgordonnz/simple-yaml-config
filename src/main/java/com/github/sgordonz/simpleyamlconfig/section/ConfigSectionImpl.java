package com.github.sgordonz.simpleyamlconfig.section;

import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;

import java.util.Map;

public class ConfigSectionImpl implements ConfigSection {
    private Map<String, ConfigSection> sections = new Object2ReferenceOpenHashMap<>();

    public ConfigSectionImpl(Map<String, ?> yaml) {
        for (Map.Entry<String, ?> entry : yaml.entrySet()) {
            Object obj = entry.getValue();
            if (obj instanceof Map) {
                sections.put(entry.getKey(), new ConfigSectionImpl((Map<String, ?>)obj));
            } else {
                sections.put(entry.getKey(), new ConfigValue(obj));
            }
        }
    }

    @Override
    public Object get(String path) {
        return get(new SectionKey(path));
    }

    @Override
    public Object get(SectionKey path) {
        String key = path.get();
        return sections.containsKey(key) ? sections.get(key).get(path) : null;
    }
}
