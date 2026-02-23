package com.penguin.smithery.ponder;

import com.penguin.smithery.CreateSmithery;
import com.penguin.smithery.index.SMPonders;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class SMPonderPlugin implements PonderPlugin {

    @Override
    public String getModId() { return CreateSmithery.MODID; }

    @SuppressWarnings("null")
    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        SMPonders.registerScenes(helper);
    }

    @SuppressWarnings("null")
    @Override
    public void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        SMPonderTags.register(helper);
    }
}