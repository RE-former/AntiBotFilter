package com.reformer.antibotfilter.listeners;

import com.reformer.antibotfilter.AntiBotFilter;
import com.reformer.antibotfilter.VerificationFunctions;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryOnJoinListener implements Listener {
    JavaPlugin plugin = AntiBotFilter.getPlugin(AntiBotFilter.class);

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        boolean verifyOnlyOnFirstJoin = plugin.getConfig().getBoolean("verifyOnlyOnFirstJoin");

        if (player.hasPermission("*") | player.isOp()) {
            if (!AntiBotFilter.spigotVersion.equalsIgnoreCase(plugin.getDescription().getVersion())) {
                player.sendMessage(ChatColor.RED + "[AntiBotFilter] -> A new version is available. Please download it here: https://www.spigotmc.org/resources/97796/");
            }
        }

        if (!player.hasPermission("antibotfilter.guibypass")) {
            if (verifyOnlyOnFirstJoin) {
                if (player.hasPlayedBefore()) {
                    return;
                } else {
                    VerificationFunctions.createVerificationInventory(plugin, e.getPlayer());
                }
            } else {
                VerificationFunctions.createVerificationInventory(plugin, e.getPlayer());
            }
        }
    }

}
