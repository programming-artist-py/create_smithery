package com.penguin.smithery.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class industrialFurnace extends Block implements EntityBlock {
    

    public industrialFurnace(Properties properties) {
        super(properties);
    }
    
    @SuppressWarnings("null")
    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new industrialFurnaceBlockEntity(pos, state);
    }

}
