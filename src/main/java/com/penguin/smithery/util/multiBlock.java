package com.penguin.smithery.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import com.penguin.smithery.CreateSmithery;

public class multiBlock {

    public static boolean checkStructureFurnace(Level level, BlockPos center) {

        for (int y = -1; y <= 1; y++) {
            for (int z = -1; z <= 1; z++) {
                for (int x = -1; x <= 1; x++) {

                    BlockPos checkPos = center.offset(x, y, z);
                    Block expected = CreateSmithery.furnacePattern[y + 1][z + 1][x + 1];
                    Block actual = level.getBlockState(checkPos).getBlock();
                    
                    if (expected == Blocks.AIR) {
                        if (!level.getBlockState(checkPos).isAir())
                            return false;
                    } else {
                        if (actual != expected)
                            return false;
                    }
                }
            }
        }
        return true;

    }

    public static void formIndustrialFurnace(Level level, BlockPos center) {
        // replace the block below the center with the industrial furnace and replace the center and all stone blocks within the 3x3x3 cube with air

        for (int y = -1; y <= 1; y++) {
            for (int z = -1; z <= 1; z++) {
                for (int x = -1; x <= 1; x++) {

                    BlockPos checkPos = center.offset(x, y, z);
                    Block expected = CreateSmithery.furnacePattern[y + 1][z + 1][x + 1];

                    if (expected == Blocks.COBBLESTONE || expected == Blocks.FURNACE) {
                        level.setBlock(checkPos, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
            }
        }
        level.setBlock(center.below(), CreateSmithery.INDUSTRIAL_FURNACE.get().defaultBlockState(), 3);
    }
}
