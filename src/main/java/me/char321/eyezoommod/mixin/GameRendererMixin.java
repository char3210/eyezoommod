package me.char321.eyezoommod.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.char321.eyezoommod.Eyezoommod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final private MinecraftClient client;

    @ModifyExpressionValue(method="getBasicProjectionMatrix", at=@At(value="INVOKE",target = "Lnet/minecraft/client/render/GameRenderer;getFov(Lnet/minecraft/client/render/Camera;FZ)D"))
    public double newFov(double original) {
        if (Eyezoommod.zoomed) {
            return Math.atan(Math.tan(original * Math.PI/360)*this.client.getWindow().getFramebufferHeight()/Eyezoommod.simulatedHeight) * 360/Math.PI;
        }
        return original;
    }
}
