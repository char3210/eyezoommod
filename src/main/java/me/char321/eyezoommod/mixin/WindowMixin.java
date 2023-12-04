package me.char321.eyezoommod.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import me.char321.eyezoommod.Eyezoommod;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Window.class)
public class WindowMixin {
    @ModifyReturnValue(method="getScaledHeight",at=@At("RETURN"))
    public int getScaledHeight(int original) {
        return Eyezoommod.zoomed ? (int) Math.ceil((double)Eyezoommod.simulatedHeight / Eyezoommod.getScaleFactor()) : original;
    }
}
