package com.gandalf.config;

import com.gandalf.CenozoicKingdom;
import oshi.util.tuples.Pair;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int fossilOreSpawnRate;
    public static int fossilOreSpawnSize;
    public static int surfacePermafrostOreSpawnRate;
    public static int surfacePermafrostOreSpawnSize;
    public static int stonePermafrostOreSpawnRate;
    public static int stonePermafrostOreSpawnSize;
    public static int deepPermafrostOreSpawnRate;
    public static int deepPermafrostOreSpawnSize;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(CenozoicKingdom.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("fossil.ore.spawn.rate", 15), "int");
        configs.addKeyValuePair(new Pair<>("fossil.ore.spawn.size", 9), "int");
        configs.addKeyValuePair(new Pair<>("surface.permafrost.ore.spawn.rate", 15), "int");
        configs.addKeyValuePair(new Pair<>("surface.permafrost.ore.spawn.size", 12), "int");
        configs.addKeyValuePair(new Pair<>("stone.permafrost.ore.spawn.rate", 5), "int");
        configs.addKeyValuePair(new Pair<>("stone.permafrost.ore.spawn.size", 12), "int");
        configs.addKeyValuePair(new Pair<>("deep.permafrost.ore.spawn.rate", 4), "int");
        configs.addKeyValuePair(new Pair<>("deep.permafrost.ore.spawn.size", 9), "int");
    }

    private static void assignConfigs() {
        fossilOreSpawnRate = CONFIG.getOrDefault("fossil.ore.spawn.rate", 15);
        fossilOreSpawnSize = CONFIG.getOrDefault("fossil.ore.spawn.size", 9);
        surfacePermafrostOreSpawnRate = CONFIG.getOrDefault("surface.permafrost.ore.spawn.rate", 15);
        surfacePermafrostOreSpawnSize = CONFIG.getOrDefault("surface.permafrost.ore.spawn.size", 12);
        stonePermafrostOreSpawnRate = CONFIG.getOrDefault("stone.permafrost.ore.spawn.rate", 5);
        stonePermafrostOreSpawnSize = CONFIG.getOrDefault("stone.permafrost.ore.spawn.size", 12);
        deepPermafrostOreSpawnRate = CONFIG.getOrDefault("deep.permafrost.ore.spawn.rate", 4);
        deepPermafrostOreSpawnSize = CONFIG.getOrDefault("deep.permafrost.ore.spawn.size", 9);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
