package vip.nostalgia.util;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MainMenuUtil {
    public static boolean isMainMenu;

    @SubscribeEvent
    public void onMainMenu(GuiScreenEvent.InitGuiEvent e) {
        if(e.gui instanceof GuiMainMenu) {
            isMainMenu = true;
        }
    }
}
