package com.example.item;

import com.example.ExampleMod;
import com.example.block.OakStoneBlock;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
// 移除 FabricItemSettings 导入，使用标准的 Item.Settings

public class ModBlocks {
    // 注册方块
    public static final Block OAK_STONE_BLOCK = Registry.register(
        Registries.BLOCK,
        new Identifier("hyf_20250817_test", "oak_stone"),
        new OakStoneBlock()
    );
    
    // 注册方块物品 - 使用新的 API
    public static final Item OAK_STONE_ITEM = Registry.register(
        Registries.ITEM,
        new Identifier("hyf_20250817_test", "oak_stone"),
        new BlockItem(OAK_STONE_BLOCK, new Item.Settings())
    );
    
    public static void registerBlocks() {
        ExampleMod.LOGGER.info("正在注册模组方块...");
        ExampleMod.LOGGER.info("橡木石头方块已注册: {}", OAK_STONE_BLOCK.getTranslationKey());
    }
}