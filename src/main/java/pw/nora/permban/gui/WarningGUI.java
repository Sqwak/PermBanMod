/*
 * Copyright 25/01/19 Nora C. / Squag
 */

package pw.nora.permban.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.FMLCommonHandler;
import pw.nora.permban.Core;
import vip.nostalgia.util.ChatColor;
import vip.nostalgia.util.MainMenuUtil;

import java.io.PrintStream;

public class WarningGUI extends GuiScreen {
    private GuiButton buttonExit;
    private GuiButton buttonUnderstand;
    private FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
    private PrintStream l = System.out;

    public void initGui() {
        super.buttonList.add(this.buttonExit = new GuiButton(1835, super.width / 2 - 100, super.height / 2 + 20, ChatColor.GREEN + "The fuck? I don't want to be banned!"));
        super.buttonList.add(this.buttonUnderstand = new GuiButton(1836, super.width / 2 - 100, super.height / 2 + 50,  ChatColor.RED + "I understand."));
    }

    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        super.drawDefaultBackground();
        this.buttonExit.drawButton(super.mc, mouseX, mouseY);
        this.buttonUnderstand.drawButton(super.mc, mouseX, mouseY);
        fr.drawStringWithShadow("If you log onto the Hypixel Network right now you will be",7,12,0xffffff);
        fr.drawStringWithShadow(">> PERMANENTLY BANNED <<",7,25,0xff0000);
        //fr.drawStringWithShadow("",7,30,0xFFFFFF);
        fr.drawStringWithShadow("If this isn't something you want to happen;",7,40,0xFFFFFF);
        fr.drawStringWithShadow("close the game and remove this mod.",7,50,0xFFFFFF);
        //fr.drawStringWithShadow("",7,60,0xFFFFFF);
        fr.drawStringWithShadow("I, Squag, am not responsible for any bans you may receive.",7,70,0xFFFFFF);
    }

    private void closeGame() {
        FMLCommonHandler.instance().exitJava(0,true);
    }

    protected void actionPerformed(final GuiButton button) {
        switch (button.id) {
            case 1835: {
                l.println("Closing game.");
                closeGame();
            }
            case 1836: {
                Core.seenWarning = true;
                this.mc.displayGuiScreen(new GuiMainMenu());
                break;
            }
        }
    }
}
