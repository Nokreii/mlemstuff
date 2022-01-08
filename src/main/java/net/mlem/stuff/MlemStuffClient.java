package net.mlem.stuff;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

public class MlemStuffClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(MlemStuff.AltheaePot, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(MlemStuff.PotShelf, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(MlemStuff.NachoHat, RenderLayer.getTranslucent());

        ScreenRegistry.register(ModScreenHandlers.LIGHTNING_CHANNELER_SCREEN_HANDLER, LightningChannelerScreen::new);
    }

}
