package br.com.stency.essentials.commands;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Aliases;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand extends CommonCommand {

    @Command("heal")
    @Aliases({"vida","cura"})
    @Permission("stency.commands.heal")
    @Override
    public void command(CommandSender commandSender, Player player, String[] strings) {
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        player.sendMessage("§aVocê foi curado(a).");
    }
}
