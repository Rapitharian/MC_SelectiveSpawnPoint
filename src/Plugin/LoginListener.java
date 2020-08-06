package Plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public final class LoginListener implements Listener {
    public LoginListener(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void normalLogin(PlayerJoinEvent event) {
        event.setJoinMessage("Welcome, " + event.getPlayer().getName() + " to the server!");
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void highLogin(PlayerLoginEvent event) {
        // Some code here
    }
}
