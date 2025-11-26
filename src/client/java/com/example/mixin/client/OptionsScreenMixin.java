package com.example.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.option.OptionsScreen;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void onInit(CallbackInfo ci) {
        // 当设置界面初始化（即打开设置界面）时显示消息
        // MinecraftClient client = MinecraftClient.getInstance();
        // if (client != null && client.player != null) {
        //     client.player.sendMessage(Text.literal("2333"), false);
        // }
    }
}


