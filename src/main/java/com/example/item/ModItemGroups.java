package com.example.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MOD_TEST_GROUP = Registry.register(
        Registries.ITEM_GROUP,
        new Identifier("hyf_20250817_test", "mod_test"),
        FabricItemGroup.builder()
            .displayName(Text.literal("模组测试1"))
            .icon(() -> new ItemStack(ModBlocks.OAK_STONE_ITEM))
            .entries((displayContext, entries) -> {
                // 添加物品到选项卡
                entries.add(ModBlocks.OAK_STONE_ITEM);
            })
            .build()
    );
    
    public static void registerItemGroups() {
        // 初始化静态字段
    }
}