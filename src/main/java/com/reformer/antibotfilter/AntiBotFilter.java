package com.reformer.antibotfilter;

import org.bukkit.plugin.java.JavaPlugin;

public final class AntiBotFilter extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("AntiBotFilter Started");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
