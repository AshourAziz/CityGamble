package main;

import org.bukkit.Bukkit;

import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import Main.Main;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;

public class ticketCount {

	public static void ticketCounter(String color, String player) {
		// Let's charge the person
		Charge(player, 20000, "&8[&c&lGamble&8] &bYou've purchased a &c&lRED &bTicket for &2&l$20,000 &bGood luck!",
				"&8[&c&lGamble&8] &c&lFailed to purchased red ticket, please report a screenshot of this to an administrator right away: Error: Charge-001");

		// Lets add a ticket to the color they've clicked to purchase.
		addTicketValue(color, player);
	}

	public static void Charge(String player, int amount, String successMessage, String failureMessage) {

		// The successMessage to send.
		String success = ChatColor.translateAlternateColorCodes('&', successMessage);

		// The failureMessage to send.
		String failure = ChatColor.translateAlternateColorCodes('&', failureMessage);

		// let's charge the player for however much was request.
		EconomyResponse r = Main.econ.bankWithdraw(player, amount);

		if (r.transactionSuccess()) {
			// If it worked, send him success message
			Bukkit.getPlayer(player).sendMessage(success);
		} else {
			// failed so let's send him the failed message
			Bukkit.getPlayer(player).sendMessage(failure);
		}

	}

	public static void addTicketValue(String player, String color) {
		// TODO: We need to move this to it's own class.
		String ticketRed = main.Main.playerTickets.get(Bukkit.getPlayer(player)).split("-")[0];
		String ticketBlack = main.Main.playerTickets.get(Bukkit.getPlayer(player)).split("-")[1];
		String ticketGreen = main.Main.playerTickets.get(Bukkit.getPlayer(player)).split("-")[2];

		if (color == "red") {
			// Let's parse the red ticket count into an int
			int redcount = Integer.parseInt(ticketRed);
			// We're going to add one to that count, because we just bought
			// a ticket
			redcount++;
			// We're going to transfer it back into a string
			ticketRed = Integer.toString(redcount);
			// recompile the amount of tickets this player has
			String recompile = ticketRed + "-" + ticketBlack + "-" + ticketGreen;
			// we're puting to put him back into the hashmap
			main.Main.playerTickets.put(player, recompile);

		} else if (color == "black") {
			int blackcount = Integer.parseInt(ticketBlack);
			blackcount++;
			ticketBlack = Integer.toString(blackcount);
			String recompile = ticketRed + "-" + ticketBlack + "-" + ticketGreen;
			main.Main.playerTickets.put(player, recompile);
		} else if (color == "green") {
			int greencount = Integer.parseInt(ticketGreen);
			greencount++;
			ticketGreen = Integer.toString(greencount);
			String recompile = ticketRed + "-" + ticketBlack + "-" + ticketGreen;
			main.Main.playerTickets.put(player, recompile);
		}
	}

}
