package datratvs.playerstats5.commands;

import datratvs.playerstats5.PlayerstatsMain;
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

	public boolean isDiscordSRVLoaded = Bukkit.getPluginManager().isPluginEnabled("DiscordSRV");

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
				Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " shared them coordinates:");

				if (isDiscordSRVLoaded) {
					WebhookUtil.deliverMessage(DiscordSRV.getPlugin().getMainTextChannel(), player, "x: " + loc.getBlockX() + " y: " + loc.getBlockY() + " z: " + loc.getBlockZ());
				} else {
					PlayerstatsMain.getInstance().getLogger().info("DiscordSRV isn't loaded, continuing without WebhookUtil.");
				}

			} else {
				Bukkit.broadcastMessage("");
				Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " shared them coordinates saying \"" + String.join(" ", args) + "\":");

				if (isDiscordSRVLoaded) {
					WebhookUtil.deliverMessage(DiscordSRV.getPlugin().getMainTextChannel(), player, "\"" + String.join(" ", args) + "\" = x: " + loc.getBlockX() + " y: " + loc.getBlockY() + " z: " + loc.getBlockZ());
				} else {
					PlayerstatsMain.getInstance().getLogger().info("DiscordSRV isn't loaded, continuing without WebhookUtil.");
				}
			}

			Bukkit.broadcastMessage(ChatColor.GOLD + "X: " + loc.getBlockX());
			Bukkit.broadcastMessage(ChatColor.GOLD + "Y: " + loc.getBlockY());
			Bukkit.broadcastMessage(ChatColor.GOLD + "Z: " + loc.getBlockZ());
			Bukkit.broadcastMessage("");
			return true;
		}
		return false;
	}
}