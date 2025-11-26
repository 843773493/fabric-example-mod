package com.example.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

public class ConfigManager {
    private static ConfigHolder<TerrainGenerationConfig> holder;

    public static synchronized void initialize() {
        holder = AutoConfig.register(TerrainGenerationConfig.class, GsonConfigSerializer::new);
        validate(holder.getConfig());
    }

    public static TerrainGenerationConfig getConfig() {
        return holder.getConfig();
    }

    // 校验与修正（保留）
    public static void validate(TerrainGenerationConfig cfg) {
        if (cfg.flightSpeed < 0.01f) cfg.flightSpeed = 0.01f;
        if (cfg.stopDampening < 0.0) cfg.stopDampening = 0.0;
    }

}
