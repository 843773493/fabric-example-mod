package com.example.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

/**
 * 统一的 Mod 配置类
 * 包括地形生成配置和飞行修改配置
 */
@Config(name = "hyf_20250817_test")
public class TerrainGenerationConfig implements ConfigData {
    
    // ========== 飞行配置 ==========
    @ConfigEntry.Gui.Tooltip
    public float flightSpeed = 0.05f;
    
    @ConfigEntry.Gui.Tooltip
    public double stopDampening = 1;
    
    @ConfigEntry.Gui.Tooltip
    public boolean enableFlightModification = true;

    public void reload() {
        // 这个方法可以在配置文件更改时被调用
        // 从配置文件读取设置
    }
}
