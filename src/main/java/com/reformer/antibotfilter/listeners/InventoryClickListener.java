package com.reformer.antibotfilter.listeners;

import com.reformer.antibotfilter.AntiBotFilter;
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


        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the red pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {

                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the cyan pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.CYAN_STAINED_GLASS_PANE) {
                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the green pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the purple pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.PURPLE_STAINED_GLASS_PANE) {
                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the pink pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.PINK_STAINED_GLASS_PANE) {
                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the brown pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.BROWN_STAINED_GLASS_PANE) {
                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the yellow pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.YELLOW_STAINED_GLASS_PANE) {
                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the gray pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&2&lClick on the black pane"))) {
            try {
                if (e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE) {
                    AntiBotFilter.playerVerify.remove(p.getUniqueId());
                    p.closeInventory();
                    p.sendMessage(ChatColor.GREEN + "Successfully verified");
                } else {
                    p.kickPlayer(ChatColor.RED + "Failed verification");
                }
            } catch (NullPointerException err) {
                //
            }
            e.setCancelled(true);
        }

    }

}
