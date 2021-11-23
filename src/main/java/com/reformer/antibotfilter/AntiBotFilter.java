package com.reformer.antibotfilter;

import com.reformer.antibotfilter.commands.VerifyCommand;
import com.reformer.antibotfilter.listeners.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public final class AntiBotFilter extends JavaPlugin {

    public static HashMap<Player, String> playerVerify = new HashMap<>();
    public static String spigotVersion;

    @Override
    public void onEnable() {
        // Loading config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        if (!getConfig().contains("enableIPFlags")) {
            getConfig().set("enableIPFlags", true);
        }
        if (!getConfig().contains("maximumDangerLevel")) {
            getConfig().set("maximumDangerLevel", 0);
        }
        if (!getConfig().contains("countdownTime")) {
            getConfig().set("countdownTime", 10);
        }
        if (!getConfig().contains("verifyOnlyOnFirstJoin")) {
            getConfig().set("verifyOnlyOnFirstJoin", true);
        }
        saveConfig();

        updateChecker();

        // Registering listeners
        getServer().getPluginManager().registerEvents(new InventoryOnJoinListener(), this);
        getServer().getPluginManager().registerEvents(new IPCheckOnJoinListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryCloseListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        // Registering commands
        getCommand("verify").setExecutor(new VerifyCommand());

        // Plugin startup logic
        getLogger().info("AntiBotFilter started");
    }

    public void updateChecker() {
        try {
            HttpsURLConnection con = (HttpsURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=97796").openConnection();
            con.setConnectTimeout(20000);
            con.setReadTimeout(20000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String version = reader.readLine();
            spigotVersion = version;
            reader.close();
            con.disconnect();
            if (version.equalsIgnoreCase(getDescription().getVersion())) {
                getLogger().info("Plugin is up to date");
            } else {
                getLogger().warning("A new version is available. Please download it here: https://www.spigotmc.org/resources/97796/");
            }
        } catch (IOException e) {
            getLogger().warning("Couldn't check for updates");
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("AntiBotFilter stopped");
    }
}
