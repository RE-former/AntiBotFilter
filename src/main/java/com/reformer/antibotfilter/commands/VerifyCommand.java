package com.reformer.antibotfilter.commands;

import com.reformer.antibotfilter.AntiBotFilter;
import com.reformer.antibotfilter.VerificationFunctions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class VerifyCommand implements CommandExecutor {
    JavaPlugin plugin = AntiBotFilter.getPlugin(AntiBotFilter.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("antibotfilter.verify")) {
            String targetString = args[0];
            Player target = Bukkit.getPlayer(targetString);
            if (args.length == 1) {
                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "Please provide a valid player");
                } else {
                    VerificationFunctions.createVerificationInventory(plugin, target);
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Please provide a player");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command (antibotfilter.verify)");
        }
        return true;
    }
}
