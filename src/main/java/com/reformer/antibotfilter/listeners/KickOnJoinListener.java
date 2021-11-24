package com.reformer.antibotfilter.listeners;

import com.reformer.antibotfilter.AntiBotFilter;
import com.reformer.antibotfilter.VerificationFunctions;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class KickOnJoinListener implements Listener {
    JavaPlugin plugin = AntiBotFilter.getPlugin(AntiBotFilter.class);
    public static ArrayList<String> needToVerify = new ArrayList<>();
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String playerName = e.getPlayer().getName();
        if (plugin.getConfig().getBoolean("kickOnFirstJoin")) {
            if (!player.hasPermission("antibotfilter.rejoinbypass")) {
                if (needToVerify.contains(playerName)) {
                    VerificationFunctions.createVerificationInventory(plugin, player);
                } else {
                    if (!player.hasPlayedBefore()) {
                        player.kickPlayer(ChatColor.RED + "Please rejoin to assure that you're a real player");
                        needToVerify.add(playerName);
                    }
                }
            }
        }
    }

}
