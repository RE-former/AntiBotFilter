package com.reformer.antibotfilter.listeners;

import com.reformer.antibotfilter.AntiBotFilter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class JoinIPCheckListener implements Listener {
    JavaPlugin plugin = AntiBotFilter.getPlugin(AntiBotFilter.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if (plugin.getConfig().getBoolean("enableIPFlags")) {
            try {
                Player player = e.getPlayer();
                HttpsURLConnection con = (HttpsURLConnection) new URL("https://check.getipintel.net/check.php?ip=" + player.getAddress().getHostString() + "&contact=admin@amazindev.com&flags=m").openConnection();
                con.setConnectTimeout(20000);
                con.setReadTimeout(20000);
                BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String dangerLevelString = reader.readLine();
                int dangerLevelInt = Integer.parseInt(dangerLevelString);
                reader.close();
                con.disconnect();

                if (!player.hasPermission("antibotfilter.ipbypass")) {
                    if (dangerLevelInt > 0) {
                        player.kickPlayer(ChatColor.RED + "Your IP is flagged. Please try rejoining later.");
                    }
                }

                plugin.getLogger().info(ChatColor.RED + player.getName() + "'s IP danger level: " + dangerLevelInt);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
