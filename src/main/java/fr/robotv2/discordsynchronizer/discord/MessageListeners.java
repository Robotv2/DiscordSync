package fr.robotv2.discordsynchronizer.discord;

import fr.robotv2.discordsynchronizer.DiscordSynchronizer;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class MessageListeners extends ListenerAdapter {

    private static final String prefix = "$";

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        if(!message.startsWith(prefix)) return;

        String[] args = message.split(" ");
        String arg0 = args[0].replace("$", "");

        switch(arg0.toLowerCase()) {
            case "link" -> onLink(event.getAuthor(), event.getTextChannel(), args);
        }
    }

    public void onLink(User user, TextChannel channel, String[] args) {
        if(args.length < 2) {
            MessageAction message = channel.sendMessage("USAGE: $link <ton-pseudo-minecraft>");
            message.queue();
            DiscordSynchronizer.getInstance().getProxy().getScheduler().schedule(DiscordSynchronizer.getInstance(), message::reset, 10, TimeUnit.SECONDS);
            return;
        }


    }
}
