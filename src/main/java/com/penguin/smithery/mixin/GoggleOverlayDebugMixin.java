package com.penguin.smithery.mixin;

import com.simibubi.create.content.equipment.goggles.GoggleOverlayRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GoggleOverlayRenderer.class)
public class GoggleOverlayDebugMixin {

    @Inject(method = "renderOverlay", at = @At("HEAD"))
    private static void logHoveredBlockEntities(CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();
        HitResult hit = mc.hitResult;

        if (!(hit instanceof BlockHitResult result)) return;

        ClientLevel world = mc.level;
        if (world == null) return;

        BlockEntity be = world.getBlockEntity(result.getBlockPos());
        if (be != null) {
            System.out.println("[GOGGLE DEBUG] Hovered BlockEntity: " + be.getType().getClass().getSimpleName() + " at " + result.getBlockPos());
        } else {
            System.out.println("[GOGGLE DEBUG] Hovered block at " + result.getBlockPos() + " has no BlockEntity");
        }
    }
}