package com.penguin.smithery.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import com.penguin.smithery.util.multiBlock;

public class ModEvents {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {

        Level level = event.getLevel();
        BlockPos pos = event.getPos();

        if (level.isClientSide) return;

        if (level.getBlockState(pos).is(Blocks.FURNACE)) {
            System.out.println("FURNACE CLICKED");

            if (multiBlock.checkStructureFurnace(level, pos)) {
                multiBlock.formIndustrialFurnace(level, pos);
            }
        }
    }
}