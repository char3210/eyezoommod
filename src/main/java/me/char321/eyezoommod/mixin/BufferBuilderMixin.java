package me.char321.eyezoommod.mixin;

import me.char321.eyezoommod.Eyezoommod;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.util.math.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BufferBuilder.class)
public interface BufferBuilderMixin {

}
