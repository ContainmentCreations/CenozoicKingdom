package com.gandalf.config;

import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.List;

public class ModConfigProvider implements SimpleConfig.DefaultConfig{
    private String configContents = "";

    public List<Pair> getConfigsList() {
        return configsList;
    }

    private final List<Pair> configsList = new ArrayList<>();

    public void addKeyValuePair(Pair<String, ?> keyValuePair, String comment) {
        configsList.add(keyValuePair);
        configContents += keyValuePair.getA() + "=" + keyValuePair.getB() + " #"
            + comment + " | default: " + keyValuePair.getB() + "\n";
    }

    @Override
    public String get(String namespace) {
        return configContents;
    }
}
