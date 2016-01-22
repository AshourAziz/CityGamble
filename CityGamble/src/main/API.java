package main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class API {

	protected static int broadcastCounter = 0;

	public static HashMap<String, String> getTicketHash() {
		return Main.playerTickets;
	}

	public static int ticketsSold() {
		int sold = getTicketHash().size();
		return sold;
	}

	public static Inventory myInventory() {

		// Create our inventory-
		Inventory myInventory = Bukkit.createInventory(null, 18, "Colors!");

		return myInventory;
	}

	public static void setBroadcastCount(int count) {
		broadcastCounter += count;

	}

	public static int getBroadcastCount() {
		return broadcastCounter;

	}

	public static void broadcast() {
		Main.getInstance().getServer().broadcastMessage(
				ChatColor.translateAlternateColorCodes('&', "&b&l/gamble is drawing VERY SOON! Buy your tickets now!"));

	}
	
	public static int Draw() {
		int winner = 0;
	
		
		return winner;
	}
	}

}
