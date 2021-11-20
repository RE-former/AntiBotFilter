package com.reformer.antibotfilter.commands;

import com.reformer.antibotfilter.AntiBotFilter;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class BlacklistIPCommand implements CommandExecutor {
    JavaPlugin plugin = AntiBotFilter.getPlugin(AntiBotFilter.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("antibotfilter.admin")) {
            if (args.length == 1) {
                ArrayList<String> badIP = (ArrayList<String>) plugin.getConfig().getStringList("blacklistIPs");
                if (badIP.contains(args[0])) {
                    sender.sendMessage(ChatColor.RED + "This IP is already blacklisted");
                } else {
                    badIP.add(args[0]);
                    plugin.getConfig().set("blacklistIPs", badIP);
                    plugin.saveConfig();

                    sender.sendMessage(ChatColor.GREEN + "Successfully added IP to the blacklist");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Please provide an IP to blacklist");
            }

        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command (antibotfilter.admin");
        }


        return true;
    }
}
