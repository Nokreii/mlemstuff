package net.mlem.stuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class MlemStuffClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(MlemStuff.AltheaePot, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(MlemStuff.PotShelf, RenderLayer.getTranslucent());
    }
}
