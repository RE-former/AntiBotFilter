package com.reformer.antibotfilter;

import com.reformer.antibotfilter.listeners.PlayerJoinLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiBotFilter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Registering events
        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveEvent(), this);

        // Plugin startup logic
        getLogger().info("AntiBotFilter started");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("AntiBotFilter stopped");
    }
}
