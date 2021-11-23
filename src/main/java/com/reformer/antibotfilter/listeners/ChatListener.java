package com.reformer.antibotfilter.listeners;

import com.reformer.antibotfilter.AntiBotFilter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if (AntiBotFilter.playerVerify.containsKey(player)) {
            e.setCancelled(true);
        }
    }

}
