package com.reformer.antibotfilter;

import com.reformer.antibotfilter.commands.BlacklistIPCommand;
import com.reformer.antibotfilter.commands.WhitelistIPCommand;
import com.reformer.antibotfilter.listeners.InventoryClickListener;
import com.reformer.antibotfilter.listeners.InventoryCloseListener;
import com.reformer.antibotfilter.listeners.PlayerJoinLeaveListener;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class AntiBotFilter extends JavaPlugin {

    public static HashMap<UUID, Inventory> playerVerify = new HashMap<>();

    @Override
    public void onEnable() {
        // Loading config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Registering events
        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryCloseListener(), this);
        getCommand("blacklistip").setExecutor(new BlacklistIPCommand());
        getCommand("whitelistip").setExecutor(new WhitelistIPCommand());


        // Plugin startup logic
        getLogger().info("AntiBotFilter started");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("AntiBotFilter stopped");


    }
}
