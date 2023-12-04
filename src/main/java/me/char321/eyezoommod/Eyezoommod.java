package me.char321.eyezoommod;

import me.char321.eyezoommod.mixin.access.WorldRendererAccess;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class Eyezoommod implements ModInitializer {
    private static MinecraftClient client;
    public static KeyBinding toggleKey;
    public static boolean zoomed = false;
    public static int simulatedHeight = 16384;

    public static void onZoom() {
        ((WorldRendererAccess) (MinecraftClient.getInstance().worldRenderer)).setNeedsTerrainUpdate(true);
    }

    public static int getScaleFactor() {
        int i;
        int height = zoomed ? simulatedHeight : client.getWindow().getFramebufferHeight();
        int width = client.getWindow().getFramebufferWidth();
        for (i = 1; i != client.options.guiScale &&
                i < width &&
                i < height &&
                width / (i + 1) >= 320 &&
                height / (i + 1) >= 240; ++i);
        if (client.options.forceUnicodeFont && i % 2 != 0) {
            ++i;
        }
        return i;
    }

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        client = MinecraftClient.getInstance();
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.eyezoommod.zoom",
                InputUtil.UNKNOWN_KEY.getCode(),
                "Eye Zoom"
        ));
    }
}
