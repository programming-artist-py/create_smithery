package com.penguin.smithery.ponder;

import com.penguin.smithery.index.SMItems;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class SMDemos {
    

    public static void BeaconDemo(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("beacon_demo", "A simple demonstration of the beacon's functionality");
        scene.configureBasePlate(0, 0, 6);
        scene.showBasePlate();
        scene.setSceneOffsetY(1);

        int normDelay = 15;

        scene.idle(normDelay);

        int placeDelay = 3;
        scene.world().showSection(util.select().position(1, 1, 1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(2, 1, 1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3, 1, 1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3, 1, 2), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(2, 1, 2), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(1, 1, 2), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(1, 1, 3), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(2, 1, 3), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3, 1, 3), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(2, 2, 2), Direction.DOWN);
        scene.idle(placeDelay);
        scene.idle(normDelay);
    }

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?, ?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);
        
        HELPER.forComponents(SMItems.EXAMPLE_ITEM).addStoryBoard("mechanical/beacon_demo", SMDemos::BeaconDemo, SMPonderTags.BEACON_DEMO);
    }
}
