package datratvs.playerstats5.commands;

import datratvs.playerstats5.PlayerstatsMain;
import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.util.WebhookUtil;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
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

			// TEST AREA

			TextComponent hyperlink = new TextComponent("Send Tpa");
			hyperlink.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpa " + player.getName()));
			hyperlink.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Send a teleport request to " + player.getName() + "!")));
			hyperlink.setColor(net.md_5.bungee.api.ChatColor.GOLD);
			hyperlink.setBold(true);

			// TEST AREA

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

			// TEST AREA

			for(Player playerHyperlink: Bukkit.getOnlinePlayers()){
				playerHyperlink.spigot().sendMessage(hyperlink);
			}

			Bukkit.broadcastMessage("");

			// TEST AREA


			return true;
		}
		return false;
	}
}