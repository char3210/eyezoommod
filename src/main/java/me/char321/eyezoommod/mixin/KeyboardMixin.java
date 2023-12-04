package me.char321.eyezoommod.mixin;

import me.char321.eyezoommod.Eyezoommod;
import me.char321.eyezoommod.mixin.access.WorldRendererAccess;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(method="onKey",at=@At("HEAD"))
    public void hotkey(long window, int key, int scancode, int i, int j, CallbackInfo ci) {
        if (i == 1 && Eyezoommod.toggleKey.matchesKey(key, scancode)) {
            Eyezoommod.zoomed = !Eyezoommod.zoomed;
            Eyezoommod.onZoom();
        }
    }
}
