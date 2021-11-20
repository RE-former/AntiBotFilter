package com.reformer.antibotfilter.listeners;

import com.reformer.antibotfilter.AntiBotFilter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryCloseListener implements Listener {
    JavaPlugin plugin = AntiBotFilter.getPlugin(AntiBotFilter.class);
    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {
        if (e.getPlayer() instanceof Player player) {
            if (e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the "))) {
                if (AntiBotFilter.playerVerify.containsKey(player.getUniqueId())) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        player.openInventory(e.getInventory());
                    }, 2L);
                }
            }
        }
    }

}
