package me.char321.eyezoommod.mixin.access;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WorldRenderer.class)
public interface WorldRendererAccess {
    @Accessor("needsTerrainUpdate")
    void setNeedsTerrainUpdate(boolean val);
}
