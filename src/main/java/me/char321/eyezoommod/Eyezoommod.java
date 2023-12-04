package me.char321.eyezoommod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class Eyezoommod implements ModInitializer {
    public static KeyBinding toggleKey;
    public static boolean zoomed = false;

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.eyezoommod.zoom",
                InputUtil.UNKNOWN_KEY.getCode(),
                "Eye Zoom"
        ));
    }
}
