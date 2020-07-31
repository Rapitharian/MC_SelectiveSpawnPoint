package Plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        //Fired when the server enables the plugin
        this.getCommand("kit").setExecutor(new CommandKit());
        this.getCommand("sleep").setExecutor(new CommandSleep());
    }
    @Override
    public void onDisable() {
        //Fired when the server stops and disables all plugins
    }
}

class CommandKit implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Create a new ItemStack (type: diamond)
            ItemStack diamond = new ItemStack(Material.DIAMOND, 32);
            // Create a new ItemStack (type: brick)
            ItemStack bricks = new ItemStack(Material.BRICK);
            // Set the amount of the ItemStack
            bricks.setAmount(20);
            // Give the player our items (comma-separated list of all ItemStack)
            player.getInventory().addItem(bricks, diamond);
        }
        // If the player (or console) uses our command correct, we can return true
        return true;
        // return false;
    }
}


class CommandSleep implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Create a new ItemStack (type: diamond)
            ItemStack dirt = new ItemStack(Material.DIRT, 10);
            // Create a new ItemStack (type: brick)
            ItemStack gravel = new ItemStack(Material.GRAVEL, 10);
            // Give the player our items (comma-separated list of all ItemStack)
            player.getInventory().addItem(dirt, gravel);
        }
        // If the player (or console) uses our command correct, we can return true
        return true;
        // return false;
    }
}