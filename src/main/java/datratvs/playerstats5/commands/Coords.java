package datratvs.playerstats5.commands;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.util.WebhookUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Coords implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("coords")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("[PS5] - The console cannot run this command.");
				return true;
			}

			Player player = (Player) sender;
			Location loc = player.getLocation();

			if (args.length == 0) {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " shared his coordinates:");


			} else {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " shared his coordinates saying \"" + String.join(" ", args) + "\":");
			}

			Bukkit.broadcastMessage(ChatColor.GOLD + "X: " + loc.getBlockX());
			Bukkit.broadcastMessage(ChatColor.GOLD + "Y: " + loc.getBlockY());
			Bukkit.broadcastMessage(ChatColor.GOLD + "Z: " + loc.getBlockZ());
			Bukkit.broadcastMessage("");

			WebhookUtil.deliverMessage(DiscordSRV.getPlugin().getMainTextChannel(), player, "/coords returned = x: " + loc.getBlockX() + " y: " + loc.getBlockY() + " z: " + loc.getBlockZ());
			return true;
		}
		return false;
	}
}