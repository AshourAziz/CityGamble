package main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;

public class ticketCount {

	public void ticketCount(String color, String player) {

		Charge(player, 20000);
		addTicketValue(color, player);
	}

	public void Charge(String player, int amount) {

		// let's charge the player for a red ticket. given to us when calling
		// "charge"
		EconomyResponse r = Main.econ.bankWithdraw(player, amount);
		String amountString = Integer.toString(amount);

		if (r.transactionSuccess()) {
			Bukkit.getPlayer(player).sendMessage(
					ChatColor.DARK_GRAY + "[" + ChatColor.RED + ChatColor.BOLD
							+ "Gamble" + ChatColor.DARK_GRAY + "]"
							+ ChatColor.AQUA + "You've purchased a "
							+ ChatColor.RED + "Red" + ChatColor.AQUA
							+ " gamble ticket, cost of $" + amountString
							+ " GOOD LUCK!");
		} else {
			Bukkit.getPlayer(player).sendMessage(""
					+ ChatColor.DARK_RED
					+ ChatColor.BOLD
					+ "ERROR OCCURED while purching a RED Ticket, please contact staff with a screenshot of this message!");
		}

	}

	public void addTicketValue(String player, String color) {
		// TODO: We need to move this to it's own class.
		String ticketRed = Main.playerTickets.get(Bukkit.getPlayer(player))
				.split("-")[0];
		String ticketBlack = Main.playerTickets.get(Bukkit.getPlayer(player))
				.split("-")[1];
		String ticketGreen = Main.playerTickets.get(Bukkit.getPlayer(player))
				.split("-")[2];

		if (color == "red") {
			// Let's parse the red ticket count into an int
			int redcount = Integer.parseInt(ticketRed);
			// We're going to add one to that count, because we just bought
			// a ticket
			redcount++;
			// We're going to transfer it back into a string
			ticketRed = Integer.toString(redcount);
			// recompile the amount of tickets this player has
			String recompile = ticketRed + "-" + ticketBlack + "-"
					+ ticketGreen;
			// we're puting to put him back into the hashmap
			Main.playerTickets.put(player, recompile);

		} else if (color == "black") {
			int blackcount = Integer.parseInt(ticketBlack);
			blackcount++;
			ticketBlack = Integer.toString(blackcount);
			String recompile = ticketRed + "-" + ticketBlack + "-"
					+ ticketGreen;
			Main.playerTickets.put(player, recompile);
		} else if (color == "green") {
			int greencount = Integer.parseInt(ticketGreen);
			greencount++;
			ticketGreen = Integer.toString(greencount);
			String recompile = ticketRed + "-" + ticketBlack + "-"
					+ ticketGreen;
			Main.playerTickets.put(player, recompile);
		}
	}

}
