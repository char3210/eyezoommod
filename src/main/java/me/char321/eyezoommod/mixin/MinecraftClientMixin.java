package me.char321.eyezoommod.mixin;

import me.char321.eyezoommod.Eyezoommod;
import me.char321.eyezoommod.mixin.access.WorldRendererAccess;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method="render", at=@At("HEAD"))
    public void zoom(boolean tick, CallbackInfo ci) {
        boolean refresh = false;
        while (Eyezoommod.toggleKey.wasPressed()) {
            Eyezoommod.zoomed = !Eyezoommod.zoomed;
            refresh = true;
        }
        if (!refresh) {
            return;
        }

        ((WorldRendererAccess) (MinecraftClient.getInstance().worldRenderer)).setNeedsTerrainUpdate(true);
    }
}
