package com.penguin.smithery.index;

import com.penguin.smithery.CreateSmithery;
import com.penguin.smithery.ponder.SMDemos;
import com.penguin.smithery.ponder.SMPonderTags;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class SMPonders {
    public static final ResourceLocation BEACON_DEMO = CreateSmithery.asResource("beacon_demo");

    public static void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.forComponents(SMItems.EXAMPLE_ITEM).addStoryBoard("mechanical/beacon_demo", SMDemos::BeaconDemo, SMPonderTags.BEACON_DEMO);

    }
}
