package datratvs.playerstats5.commands;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("ping")) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("[PS5] - The console cannot run this command.");
				return true;
			}

			Player player = (Player) sender;

			Player receiver;

			if (args.length == 0) {
				receiver = (Player) sender;
			} else {
				receiver = Bukkit.getPlayer(args[0]);
			}

			if (receiver == null) {
				player.sendMessage(ChatColor.GOLD + "[PS5] - Either this player doesn't exist or it's offline.");
				return true;
			}

			TextComponent actionBar = new TextComponent(net.md_5.bungee.api.ChatColor.GOLD + receiver.getName() + "'s latency is: " + receiver.getPing());
			player.spigot().sendMessage(ChatMessageType.ACTION_BAR, actionBar);

			return true;
		}
		return false;
	}
}