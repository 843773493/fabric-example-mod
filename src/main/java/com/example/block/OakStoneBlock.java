package com.example.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class OakStoneBlock extends Block {
    public OakStoneBlock() {
        // 使用石头的完整属性，包括硬度、抗爆性等
        super(Settings.copy(Blocks.STONE));
    }
    
    // 移除 getHardness 方法，因为在 1.20.1 中不需要重写
    // 所有属性都通过 Settings.copy(Blocks.STONE) 继承
}


