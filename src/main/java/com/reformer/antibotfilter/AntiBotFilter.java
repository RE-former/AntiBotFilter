package com.reformer.antibotfilter;

import com.reformer.antibotfilter.commands.AddBadIPCommand;
import com.reformer.antibotfilter.listeners.InventoryClickListener;
import com.reformer.antibotfilter.listeners.PlayerJoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class AntiBotFilter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Loading config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Registering events
        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getCommand("addbadip").setExecutor(new AddBadIPCommand());

        // Plugin startup logic
        getLogger().info("AntiBotFilter started");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("AntiBotFilter stopped");


    }
}
