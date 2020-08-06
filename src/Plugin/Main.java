package Plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        //Fired when the server enables the plugin
        Objects.requireNonNull(this.getCommand("kit")).setExecutor(new CommandKit());
        new EventListener(this);
    }
    @Override
    public void onDisable() {
        //Fired when the server stops and disables all plugins
        HandlerList.unregisterAll(this);
    }
}

class CommandKit implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Create a new ItemStack (type: Bed)
            ItemStack bed = new ItemStack(Material.WHITE_BED, 1);
            //ItemStack bed = new ItemStack(Objects.requireNonNull(Material.getMaterial(bed)), 1);
            // Give the player our items (comma-separated list of all ItemStack)
            player.getInventory().addItem(bed);
        }
        // If the player (or console) uses our command correct, we can return true
        return true;
        // return false;
    }
}