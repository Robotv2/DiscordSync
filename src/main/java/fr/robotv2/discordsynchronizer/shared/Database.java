package fr.robotv2.discordsynchronizer.shared;

import fr.robotv2.discordsynchronizer.DiscordSynchronizer;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Database {

    private static File file;
    private static Configuration configuration;

    public static void setup() {
        try {

            file = new File(DiscordSynchronizer.getInstance().getDataFolder(), "database.yml");
            if(!file.exists())
                file.mkdir();
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(DiscordSynchronizer.getInstance().getDataFolder(), "database.yml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configuration get() {
        return configuration;
    }

    public static void reload() {
        try {
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(DiscordSynchronizer.getInstance().getDataFolder(), "database.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
