package datratvs.playerstats5;

import datratvs.playerstats5.commands.Coords;
import datratvs.playerstats5.commands.Ping;
import datratvs.playerstats5.commands.Ps;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PlayerstatsMain extends JavaPlugin {

	public static PlayerstatsMain instance;

	public static PlayerstatsMain getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {

		instance = this;

		getLogger().info("[PS5] - Bota a chaproca pra correr que tu vai ver uns stats agora nessa merda filho da puta");

		Objects.requireNonNull(this.getCommand("coords")).setExecutor(new Coords());
		Objects.requireNonNull(this.getCommand("ps")).setExecutor(new Ps());
		Objects.requireNonNull(this.getCommand("ping")).setExecutor(new Ping());

	}

	@Override
	public void onDisable() {

		getLogger().info("): ɐʇnd ɐp oɥlıɟ ɐpɹǝɯ ɐssǝu ɐɹoƃɐ sʇɐʇs sunu nʇ ǝnb ɹǝɹɹoɔ ɐɹd ɐɔoɹdɐɥɔ ɐ ɐʇo\uD801\uDC12 - [ގSԀ]");

	}
}
