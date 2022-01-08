package net.mlem.stuff;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<LightningChannelerScreenHandler> LIGHTNING_CHANNELER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier("mlemstuff", "lightning_channeler"),
                    LightningChannelerScreenHandler::new);
}