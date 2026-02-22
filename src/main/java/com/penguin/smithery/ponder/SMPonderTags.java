package com.penguin.smithery.ponder;

import com.penguin.smithery.CreateSmithery;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

public class SMPonderTags {
    public static final ResourceLocation

    BEACON_DEMO = CreateSmithery.asResource("beacon_demo");

    public static void register(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderTagRegistrationHelper<RegistryEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.registerTag(BEACON_DEMO)
            .addToIndex()
            .item(Blocks.BEACON.asItem(), true, false)
            .register();

    }
}
