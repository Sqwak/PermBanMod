/*
 * Copyright 25/01/19 Nora C. / Squag
 */

package pw.nora.permban;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import pw.nora.permban.gui.WarningGUI;
import vip.nostalgia.util.MainMenuUtil;

import static vip.nostalgia.util.MainMenuUtil.isMainMenu;

@Mod(modid = "Lynx", name = "The Perm Ban Mod", version = "2.0.2")
public class Core {
    public static boolean seenWarning = false;

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new MainMenuUtil());
    }

    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent e) {
        if(isMainMenu && !seenWarning) {
            Minecraft.getMinecraft().displayGuiScreen(new WarningGUI());
        }
    }
}
