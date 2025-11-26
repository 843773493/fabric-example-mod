package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.item.ModBlocks;
import com.example.item.ModItemGroups;

import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer{
    public static final String MOD_ID = "hyf_20250817_test";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        
        // 注册方块和物品
        ModBlocks.registerBlocks();
        ModItemGroups.registerItemGroups();
        
    }
}