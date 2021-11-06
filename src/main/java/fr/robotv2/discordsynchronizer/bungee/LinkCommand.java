package fr.robotv2.discordsynchronizer.bungee;

import fr.robotv2.discordsynchronizer.shared.DiscordAPI;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class LinkCommand extends Command {

    public LinkCommand() {
        super("discord-link");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0)
            return;

        if(!(sender instanceof ProxiedPlayer player))
            return;

        if(!Bungee.playerCache.contains(player.getUniqueId()))
            return;

        if(args[0].equalsIgnoreCase("accept")) {

            Bungee.playerCache.remove(player.getUniqueId());
            Bungee.sendMessage(sender, "&aVous venez d'accepter cette synchronisation à votre compte.");

        } else if(args[0].equalsIgnoreCase("deny")) {

            Bungee.playerCache.remove(player.getUniqueId());
            Bungee.sendMessage(sender, "&cVous venez de refuser cette synchronisation à votre compte.");

        }
    }
}
