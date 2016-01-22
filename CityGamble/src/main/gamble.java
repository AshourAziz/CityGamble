package main;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class gamble implements CommandExecutor {

    private Main plugin;


    // Red, Black, Green
    static String ticketSetup = "0-0-0";

    // Define our stacks of items.
    protected ItemStack redwool;

    static {

        // Information for the Red Wool
        ItemStack redwool = new ItemStack(Material.WOOL, 1, (byte) 14);
        ItemMeta redwoolmeta = redwool.getItemMeta();
        redwoolmeta.setDisplayName("redwool");
        ArrayList<String> redwoollore = new ArrayList<String>();
        redwoollore.add(ChatColor.RED + "Tickets Purchased: 0");
        redwoolmeta.setLore(redwoollore);
        redwool.setItemMeta(redwoolmeta);
        // end of information for the red wool

        // This will add the three items.
        // Red, Black, LimeGreen
        API.myInventory().setItem(3, new ItemStack(Material.WOOL, 1, (byte) 14));
        API.myInventory().setItem(5, new ItemStack(Material.WOOL, 1, (byte) 15));
        API.myInventory().setItem(7, new ItemStack(Material.WOOL, 7, (byte) 5));
    }

    public gamble(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("gamble")) {
            Player player = (Player) sender;
            player.openInventory(API.myInventory());

            return true;
        }

        return false;
    }

    public String calculateWinningColor() {
        int winner = (int) Math.random() * 100;

        String winningColor = "";

        if (winner > 0 && winner < 11) {
            winningColor = "red";

        } else if (winner > 11 && winner < 31) {
            winningColor = "black";
        } else if (winner > 31 && winner < 61) {
            winningColor = "green";

        } else if (winner > 61 && winner < 101) {
            winningColor = "blue";
        }
        return winningColor;

    }

}