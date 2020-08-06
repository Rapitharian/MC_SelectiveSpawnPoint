package Plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;

public final class EventListener implements Listener {
    public EventListener(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void normalLogin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.RED + "Welcome, " + event.getPlayer().getName() + " to the server!");
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void inBed(PlayerBedEnterEvent event) {
        if (!event.isCancelled()) {
            //Code if cancelled.
            Bukkit.broadcastMessage("[SSP:] " + event.getPlayer().getName() + " is sleeping in a bed. PEELS Now!");
        } else {
            //Bukkit.broadcastMessage(ChatColor.RED + event.getPlayer().getName() + " is sleeping in a bed!");
        }
    }
}
