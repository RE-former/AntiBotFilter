package com.reformer.antibotfilter.commands;

import com.reformer.antibotfilter.AntiBotFilter;
import com.reformer.antibotfilter.VerificationFunctions;
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
            Player target = (Player) sender;
            if (args.length == 1) {
                VerificationFunctions.createVerificationInventory(plugin, target);
            } else {
                sender.sendMessage(ChatColor.RED + "Please provide a player");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command (antibotfilter.verify");
        }
        return true;
    }
}
