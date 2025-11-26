package com.example;

import org.lwjgl.glfw.GLFW;

import com.example.config.ConfigManager;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.option.KeyBinding;  // 正确的导入
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.math.Vec3d;


public class ExampleModClient implements ClientModInitializer {
    private static KeyBinding autoForwardKey;
    private static boolean autoForward = false;

    @Override
    public void onInitializeClient() {
        ConfigManager.initialize();

        // 注册自动前进按键
        autoForwardKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.autoforward.toggle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_C,
            "category.autoforward"
        ));

        // 合并 tick 回调
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // 1. 自动前进切换
            while (autoForwardKey.wasPressed()) {
                autoForward = !autoForward;
                if (!autoForward) {
                    client.options.forwardKey.setPressed(false);
                }
            }

            // 2. 飞行速度 / 阻尼
            if (client.player != null && client.player.getAbilities().flying) {
                var cfg = ConfigManager.getConfig();
                if (cfg.enableFlightModification) {
                    client.player.getAbilities().setFlySpeed(cfg.flightSpeed);
                    Vec3d v = client.player.getVelocity();
                    double d = cfg.stopDampening;
                    client.player.setVelocity(v.x * d, v.y * d, v.z * d);
                }
            }

            // 3. 自动前进维持
            if (autoForward) {
                if (client.player == null) {
                    autoForward = false;
                    client.options.forwardKey.setPressed(false);
                    return;
                }
                // 若玩家主动按住 S（后退）则临时让出控制
                if (client.options.backKey.isPressed()) {
                    client.options.forwardKey.setPressed(false);
                } else {
                    client.options.forwardKey.setPressed(true);
                }
            }
        });

        // 断线时重置
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            if (autoForward) {
                autoForward = false;
                client.options.forwardKey.setPressed(false);
            }
        });

    }
}