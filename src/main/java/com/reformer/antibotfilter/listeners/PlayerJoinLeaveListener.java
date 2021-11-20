package com.reformer.antibotfilter.listeners;


import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class PlayerJoinLeaveListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        List<String> badips = Arrays.asList("1.1.1.1","127.0.0.1");
        Player player = (Player) e.getPlayer();
        String playerIP = player.getAddress().getAddress().getHostAddress();
        if(badips.contains(playerIP)){
            player.kickPlayer("Your IP is blacklisted");
        }
        player.sendMessage("Your IP is:- " + playerIP);

        List<String> listOfColors = Arrays.asList("red", "cyan", "green", "purple", "pink", "brown", "yellow", "gray", "black");
        int indexColor = (int)(Math.random()*listOfColors.size());
        String randomColor = listOfColors.get(indexColor);

        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', "&2&lClick on the " + randomColor + " pane"));
        e.getPlayer().openInventory(inv);

        List<Material> listOfPanes = Arrays.asList(Material.RED_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.PINK_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.BLACK_STAINED_GLASS_PANE);

        while (inv.firstEmpty() != -1) {
            int indexMaterial = (int)(Math.random()*listOfPanes.size());
            ItemStack itemStack = new ItemStack(listOfPanes.get(indexMaterial));

            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(" ");
            itemStack.setItemMeta(itemMeta);

            inv.addItem(itemStack);
            inv.setMaxStackSize(1);
        }


    }

}
