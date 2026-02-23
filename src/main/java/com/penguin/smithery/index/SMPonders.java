package com.penguin.smithery.index;

import com.penguin.smithery.ponder.SMDemos;
import com.penguin.smithery.ponder.SMPonderTags;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class SMPonders {

    public static void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<RegistryEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.forComponents(SMItems.EXAMPLE_ITEM).addStoryBoard("smithery/beacon_demo", SMDemos::BeaconDemo, SMPonderTags.BEACON_DEMO);
        HELPER.forComponents(SMItems.INDUSTRIAL_FURNACE).addStoryBoard("smithery/industrial_furnace_demo", SMDemos::IndustrialFurnaceDemo, SMPonderTags.FURNACE_DEMO);
    }
}
