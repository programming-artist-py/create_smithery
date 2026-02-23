package com.penguin.smithery.ponder;

import com.penguin.smithery.CreateSmithery;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;

import net.createmod.ponder.api.PonderPalette;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec3;

public class SMDemos {
    

    public static void IndustrialFurnaceDemo(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("industrial_furnace_demo", "A simple demonstration of how to build the industrial furnace");
        scene.configureBasePlate(0, 0, 6);
        scene.showBasePlate();
        scene.setSceneOffsetY(1);

        int normDelay = 15; // ticks

        int placeDelay = 3; // ticks

        int layerDelay = 1; // seconds

        scene.idle(normDelay);

        scene.world().showSection(util.select().position(1,1,1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3,1,1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(2,1,2), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(1,1,3), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3,1,3), Direction.DOWN);
        scene.idleSeconds(layerDelay);
        scene.world().showSection(util.select().position(1,2,1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3,2,1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(2,2,2), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(1,2,3), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3,2,3), Direction.DOWN);
        scene.idleSeconds(layerDelay);
        scene.world().showSection(util.select().position(1,3,1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(2,3,1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3,3,1), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3,3,2), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(1,3,2), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(1,3,3), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(2,3,3), Direction.DOWN);
        scene.idle(placeDelay);
        scene.world().showSection(util.select().position(3,3,3), Direction.DOWN);
        scene.idle(placeDelay);
        scene.idle(normDelay);

        Vec3 arrowVec = util.vector().centerOf(2, 2, 2);

        scene.overlay().showText(60)
            .text("Once built, right click the furnace to assemble.")
            .pointAt(arrowVec)
            .attachKeyFrame()
            .placeNearTarget()
            .colored(PonderPalette.GREEN);

        scene.idleSeconds(layerDelay * 4);

        scene.world().hideSection(util.select().position(1,1,1), Direction.DOWN);
        scene.world().hideSection(util.select().position(3,1,1), Direction.DOWN);
        scene.world().hideSection(util.select().position(1,1,3), Direction.DOWN);
        scene.world().hideSection(util.select().position(3,1,3), Direction.DOWN);
        scene.world().hideSection(util.select().position(1,2,1), Direction.DOWN);
        scene.world().hideSection(util.select().position(3,2,1), Direction.DOWN);
        scene.world().hideSection(util.select().position(2,2,2), Direction.DOWN);
        scene.world().hideSection(util.select().position(1,2,3), Direction.DOWN);
        scene.world().hideSection(util.select().position(3,2,3), Direction.DOWN);
        scene.world().hideSection(util.select().position(1,3,1), Direction.DOWN);
        scene.world().hideSection(util.select().position(2,3,1), Direction.DOWN);
        scene.world().hideSection(util.select().position(3,3,1), Direction.DOWN);
        scene.world().hideSection(util.select().position(3,3,2), Direction.DOWN);
        scene.world().hideSection(util.select().position(1,3,2), Direction.DOWN);
        scene.world().hideSection(util.select().position(1,3,3), Direction.DOWN);
        scene.world().hideSection(util.select().position(2,3,3), Direction.DOWN);
        scene.world().hideSection(util.select().position(3,3,3), Direction.DOWN);


        BlockPos furnacePos = new BlockPos(2, 1, 2);

        scene.world().setBlock(furnacePos, CreateSmithery.INDUSTRIAL_FURNACE.get().defaultBlockState(), false);

        scene.idleSeconds(placeDelay);
    }



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


}
