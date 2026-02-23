package com.penguin.smithery.block;

import joptsimple.internal.Strings;
import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.fluid.SmartFluidTankBehaviour;
import com.simibubi.create.foundation.utility.CreateLang;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import com.penguin.smithery.CreateSmithery;

import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction;
import java.util.List;

public class industrialFurnaceBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {

    public SmartFluidTankBehaviour tankBehaviour;

    private int minValue = 0;
    private int maxValue = 0;

    public industrialFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(CreateSmithery.INDUSTRIAL_FURNACE_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        tankBehaviour = SmartFluidTankBehaviour.single(this, 1000)
                .whenFluidUpdates(this::setChanged);
        behaviours.add(tankBehaviour);
    }

    @SuppressWarnings("removal")
    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        int lvl = 4;

        FluidStack stack = tankBehaviour.getPrimaryHandler().getFluid();
        
        if (stack.isEmpty()) {
                tooltip.add(Component.literal(" ".repeat(lvl) + "Empty"));
                return true;
            } else {
                tooltip.add(Component.literal(" ".repeat(lvl) + stack.getDisplayName().getString() + ": " + stack.getAmount() + " mB"));
                return true;
            }
    }

    // Optional convenience methods to interact with the tank manually
    public int fill(FluidStack stack) {
        return tankBehaviour.getPrimaryHandler().fill(stack, FluidAction.EXECUTE);
    }

    public FluidStack drain(int amount) {
        return tankBehaviour.getPrimaryHandler().drain(amount, FluidAction.EXECUTE);
    }

    private MutableComponent blockComponent(int level) {
        return Component.literal("" + "\u2588".repeat(minValue) + "\u2592".repeat(level - minValue) + "\u2591".repeat(maxValue - level));
    }

    public MutableComponent getWaterComponent(boolean forGoggles, boolean useBlocksAsBars, ChatFormatting... styles) {
        return componentHelper("water", 100, forGoggles, useBlocksAsBars, styles);
    }

    private MutableComponent componentHelper(String label, int level, boolean forGoggles, boolean useBlocksAsBars, ChatFormatting... styles) {
        MutableComponent base = useBlocksAsBars ? blockComponent(level) : barComponent(level);

        if (!forGoggles)
            return base;

        ChatFormatting style1 = styles.length >= 1 ? styles[0] : ChatFormatting.GRAY;
        ChatFormatting style2 = styles.length >= 2 ? styles[1] : ChatFormatting.DARK_GRAY;

        return CreateLang.translateDirect("furnace." + label)
                .withStyle(style1)
                .append(CreateLang.translateDirect("furnace." + label + "_dots")
                        .withStyle(style2))
                .append(base)
                .append("("+level/10f+")");
    }

    private MutableComponent barComponent(int level) {
        ChatFormatting color = level - minValue >19 ? ChatFormatting.DARK_RED : ChatFormatting.DARK_GREEN;
        switch (level - minValue) {
            case 1: color = ChatFormatting.BLUE; break;
            case 2: color = ChatFormatting.DARK_AQUA; break;
            case 3: color = ChatFormatting.DARK_AQUA; break;
            case 4: color = ChatFormatting.AQUA; break;
            case 5: color = ChatFormatting.AQUA; break;
            case 6: color = ChatFormatting.AQUA; break;
            case 7: color = ChatFormatting.AQUA; break;
            case 8: color = ChatFormatting.AQUA; break;
            case 11: color = ChatFormatting.YELLOW; break;
            case 12: color = ChatFormatting.YELLOW; break;
            case 13: color = ChatFormatting.YELLOW; break;
            case 14: color = ChatFormatting.YELLOW; break;
            case 15: color = ChatFormatting.YELLOW; break;
            case 16: color = ChatFormatting.GOLD; break;
            case 17: color = ChatFormatting.RED; break;
            case 18: color = ChatFormatting.RED; break;
            case 19: color = ChatFormatting.DARK_RED; break;

        }

        return Component.empty()
                .append(bars(Math.max(0, minValue - 1), ChatFormatting.RED))
                .append(bars(minValue > 0 ? 1 : 0, ChatFormatting.GOLD))
                .append(bars(Math.max(0, level - minValue), color))
                .append(bars(Math.max(0, maxValue - level), ChatFormatting.BLUE))
                .append(bars(Math.max(0, Math.min(18 - maxValue, ((maxValue / 5 + 1) * 5) - maxValue)),
                        ChatFormatting.DARK_GRAY));

    }


    private MutableComponent bars(int level, ChatFormatting format) {
        return Component.literal(Strings.repeat('|', level))
                .withStyle(format);
    }

}