package com.reformer.antibotfilter.commands;


import com.reformer.antibotfilter.AntiBotFilter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class AddBadIPCommand implements CommandExecutor {
    JavaPlugin plugin = AntiBotFilter.getPlugin(AntiBotFilter.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<String> badIP = plugin.getConfig().getStringList("blacklistIPs");
        badIP.add(args[0]);
        plugin.getConfig().set("blacklistIPs", badIP);
        plugin.saveConfig();

        return true;
    }
}
