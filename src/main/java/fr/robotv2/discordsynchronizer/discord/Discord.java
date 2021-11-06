package fr.robotv2.discordsynchronizer.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Discord {

    private static JDA jda;

    public static void init() {
        try {

            jda = JDABuilder.createDefault("OTA2NjM2OTE5MjcyNzgzOTcy.YYbhbg.g-6D-NQeXrTfaRTE4WtxpWVVD5w").build().awaitReady();
            if(jda == null) return;

            jda.getPresence().setActivity(Activity.playing("Cinestia"));
            jda.addEventListener(new MessageListeners());

        } catch (LoginException | InterruptedException ignored) {
        }

    }

    public static void shutdown() {
        jda.shutdownNow();
    }

}
