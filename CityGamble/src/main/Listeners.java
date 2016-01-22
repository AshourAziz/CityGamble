package main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class Listeners {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();
        // Check if it's our inventory
        if (inventory.getName().equals(API.myInventory().getName())) {
            // Check if the player is null, if so we'll set him with the
            // defeault setup.
            if (Main.playerTickets.get(player.getName()) == null) {
                Main.playerTickets.put(player.getName(), gamble.ticketSetup);
            }
            // Cancel the event
            event.setCancelled(true);
            if (clicked.equals(API.myInventory().getItem(3))) {
                // slot number 3 is red.
                ticketCount.ticketCounter("red", player.getName());
            } else if (clicked.equals(API.myInventory().getItem(5))) {
                // slot 5 is black
                ticketCount.ticketCounter("black", player.getName());

            } else if (clicked.equals(API.myInventory().getItem(7))) {
                // slot 7 is green
                ticketCount.ticketCounter("green", player.getName());
            }

            // TODO: Call something that'll check if x tickets sold and if so
            // we'll start a runabble
            // to start a countdown to launch and pick the winners.

            new BukkitRunnable() {
                public void run() {
                    if (API.ticketsSold() > 2 && API.getBroadcastCount() < 3) {
                        API.setBroadcastCount(1);
                        API.broadcast();
                    }
                    if (API.getBroadcastCount() > 3) {
                        String winner = API.draw();
                        API.messageWinners(winner);
                        API.payWinners();
                    }

                }
            }.runTaskTimer(Main.getInstance(), 1200l, 1200l);

        }
        // playerTickets.put(player.getName(), "Red-" + ticketsbought);
    }
}
