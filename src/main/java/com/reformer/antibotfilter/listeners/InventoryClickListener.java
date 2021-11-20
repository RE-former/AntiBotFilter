package com.reformer.antibotfilter.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the red pane"))) {
            if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the cyan pane"))) {
            if (e.getCurrentItem().getType() == Material.CYAN_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the green pane"))) {
            if (e.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the purple pane"))) {
            if (e.getCurrentItem().getType() == Material.PURPLE_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the pink pane"))) {
            if (e.getCurrentItem().getType() == Material.PINK_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the brown pane"))) {
            if (e.getCurrentItem().getType() == Material.BROWN_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the yellow pane"))) {
            if (e.getCurrentItem().getType() == Material.YELLOW_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the gray pane"))) {
            if (e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the black pane"))) {
            if (e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE) {
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully verified");
            } else {
                p.kickPlayer(ChatColor.RED + "Failed verification");
            }
        }

    }

}
