package com.reformer.antibotfilter;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public class VerificationFunctions {

    public static void createVerificationInventory(JavaPlugin plugin, Player player) {
        int countdownTime = plugin.getConfig().getInt("countdownTime");
        long time = 20L * countdownTime;
        List<String> listOfColors = Arrays.asList("red", "cyan", "green", "purple", "pink", "brown", "yellow", "gray", "black");
        int indexColor = (int)(Math.random()*listOfColors.size());
        String randomColor = listOfColors.get(indexColor);
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', "&2&lClick on the " + randomColor + " pane"));
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

        player.openInventory(inv);
        AntiBotFilter.playerVerify.put(player.getUniqueId(), randomColor);

        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            if (AntiBotFilter.playerVerify.containsKey(player.getUniqueId())) {
                player.kickPlayer(ChatColor.RED + "Took too long to verify. Please try again.");
            }
        }, time);
    }

}
