package datratvs.playerstats5.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Ps implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("ps")) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("[PS5] - The console cannot run this command.");
			return true;
		}

		Player player = (Player) sender;

		/* if (args.length == 0) {
			player.sendMessage(ChatColor.GOLD + "[PS5] - Usage: /ps (player)");
			return true;
		} */

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

			player.sendMessage(ChatColor.RED + "---------------------- [] ----------------------");
			player.sendMessage("");
			player.sendMessage(ChatColor.RED + "Visualizing " + receiver.getName() + "'s Stats.");
			player.sendMessage("");
			player.sendMessage(receiver.getStatistic(Statistic.DEATHS) + " deaths.");
			player.sendMessage(receiver.getStatistic(Statistic.MOB_KILLS) + " mob kills.");
			player.sendMessage(receiver.getStatistic(Statistic.PLAYER_KILLS) + " player kills.");
			player.sendMessage(receiver.getStatistic(Statistic.DAMAGE_DEALT) + " damage dealt.");
			player.sendMessage(receiver.getStatistic(Statistic.ANIMALS_BRED) + " animals bred.");
			player.sendMessage(receiver.getStatistic(Statistic.JUMP) + " jumps.");
			player.sendMessage(receiver.getStatistic(Statistic.WALK_ONE_CM) + "cm walked, and " + receiver.getStatistic(Statistic.SPRINT_ONE_CM) + "cm sprinted.");

			float play_one_minute = receiver.getStatistic(Statistic.PLAY_ONE_MINUTE);
			float play_one_hour = play_one_minute / 1200 / 60;

			player.sendMessage(play_one_hour + " hours played.");
			player.sendMessage("");
			player.sendMessage(ChatColor.RED + "---------------------- [] ----------------------");

			return true;
		}
		return false;
	}
}
