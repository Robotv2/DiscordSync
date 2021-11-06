package fr.robotv2.discordsynchronizer.shared;

import fr.robotv2.discordsynchronizer.DiscordSynchronizer;
import fr.robotv2.discordsynchronizer.bungee.Bungee;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MinecraftAPI {

    public static boolean isConnected(String playerNAME) {
        ProxiedPlayer target = DiscordSynchronizer.getInstance().getProxy().getPlayer(playerNAME);
        return target != null && target.isConnected();
    }

    public static void sendMessage(String playerNAME, String discordId) {
        ProxiedPlayer target = DiscordSynchronizer.getInstance().getProxy().getPlayer(playerNAME);
        Bungee.sendIdMessage(target, discordId);
    }
}
