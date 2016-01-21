package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import me.libraryaddict.inventory.InventoryApi;
import me.libraryaddict.inventory.ItemBuilder;
import me.libraryaddict.inventory.PageInventory;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.economy.EconomyResponse;

public class gamble implements CommandExecutor {

	private Main plugin;

	// Create our inventory
	public static Inventory myInventory = Bukkit.createInventory(null, 18, "Colors!");

	// Red, Black, Green
	String ticketSetup = "0-0-0";

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
		myInventory.setItem(3, new ItemStack(Material.WOOL, 1, (byte) 14));
		myInventory.setItem(5, new ItemStack(Material.WOOL, 1, (byte) 15));
		myInventory.setItem(7, new ItemStack(Material.WOOL, 7, (byte) 5));
	}

	public gamble(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("gamble")) {
			Player player = (Player) sender;
			player.openInventory(myInventory);

			return true;
		}

		return false;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();

		// Check if it's our inventory
		if (inventory.getName().equals(myInventory.getName())) {
			// Check if the player is null, if so we'll set him with the
			// defeault setup.
			if (Main.playerTickets.get(player.getName()) == null) {
				Main.playerTickets.put(player.getName(), ticketSetup);
			}

			// Cancel the event
			event.setCancelled(true);

			if (clicked.equals(myInventory.getItem(3))) {
				// slot number 3 is red.
				ticketCount.ticketCounter("red", player.getName());
			} else if (clicked.equals(myInventory.getItem(5))) {
				// slot 5 is black
				ticketCount.ticketCounter("black", player.getName());

			} else if (clicked.equals(myInventory.getItem(7))) {
				// slot 7 is green
				ticketCount.ticketCounter("green", player.getName());

			}

		}

		// playerTickets.put(player.getName(), "Red-" + ticketsbought);

	}
}