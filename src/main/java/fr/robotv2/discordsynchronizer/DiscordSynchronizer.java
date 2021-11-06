package fr.robotv2.discordsynchronizer;

import fr.robotv2.discordsynchronizer.bungee.Bungee;
import fr.robotv2.discordsynchronizer.discord.Discord;
import net.md_5.bungee.api.plugin.Plugin;

public final class DiscordSynchronizer extends Plugin {

    private static DiscordSynchronizer INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        Discord.init();
        Bungee.init();
    }

    @Override
    public void onDisable() {
        Discord.shutdown();
        Bungee.shutdown();
        INSTANCE = null;
    }

    public static DiscordSynchronizer getInstance() {
        return INSTANCE;
    }
}
