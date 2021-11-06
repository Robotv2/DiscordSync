package fr.robotv2.discordsynchronizer.bungee;

import fr.robotv2.discordsynchronizer.DiscordSynchronizer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bungee {

    private static BaseComponent yesMessage;
    private static BaseComponent noMessage;

    public static final List<UUID> playerCache = new ArrayList<>();

    public static void init() {
        createMessage();
        DiscordSynchronizer.getInstance().getProxy().getPluginManager().registerCommand(DiscordSynchronizer.getInstance(), new LinkCommand());
    }

    public static void shutdown() {
    }

    private static void createMessage() {
        TextComponent yesText = new TextComponent("[OUI]");
        yesText.setColor(ChatColor.GREEN);
        yesText.setBold(true);
        yesText.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Oui, c'est bien moi !").color(ChatColor.WHITE).create()));
        yesText.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "discord-link accept"));
        yesMessage = yesText;

        TextComponent noText = new TextComponent("[NON]");
        noText.setColor(ChatColor.RED);
        noText.setBold(true);
        noText.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Non, ce n'est pas moi !").color(ChatColor.RED).create()));
        noText.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "discord-link deny"));
        noMessage = noText;
    }

    public static void sendMessage(CommandSender sender, String message) {
        TextComponent lastMessage = new TextComponent(message.replace('&', ChatColor.COLOR_CHAR));
        sender.sendMessage(lastMessage);
    }

    public static void sendIdMessage(ProxiedPlayer player, String discordID) {
        String message = "&7Es-tu entrain de connecter ton compte &3Discord &7avec ce compte Minecraft ? &8(&7" + discordID + "&8) ";
        TextComponent firstText = new TextComponent(message.replace('&', ChatColor.COLOR_CHAR));
        player.sendMessage(firstText);
        player.sendMessage(yesMessage, noMessage);
    }
}
