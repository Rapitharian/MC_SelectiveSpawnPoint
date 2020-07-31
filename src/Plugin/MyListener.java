package Plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        ExampleEvent exampleEvent = new ExampleEvent("Frontesque"); // Initialize your Event
        Bukkit.getPluginManager().callEvent(exampleEvent); // This fires the event and allows any listener to listen to the event
        if (!exampleEvent.isCancelled()) {
            Bukkit.getPlayer("Frontesque").sendMessage(exampleEvent.getPlayerName()); // Use your event's data
        }
        event.setJoinMessage("Welcome, " + event.getPlayer().getName() + " to the server!");
    }
    // Executes before the second method because it has a much lower priority.
    @EventHandler (priority = EventPriority.LOWEST)
    public void onPlayerChat1(AsyncPlayerChatEvent event)
    {
        event.setCancelled(true);
    }
    // Will not execute unless another listener with a  lower priority has uncancelled the event.
    @EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerChat2(AsyncPlayerChatEvent event)
    {
        System.out.println("This shouldn't be executing.");
    }
}
