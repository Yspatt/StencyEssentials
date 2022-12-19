package br.com.stency.essentials.commands;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import com.google.common.collect.Lists;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class GodCommand extends CommonCommand {

    @Getter
    private static List<Player> playerList = Lists.newArrayList();

    @Command("god")
    @Permission("stency.commands.god")
    @Override
    public void command(CommandSender commandSender, Player player, String[] arguments) {
        if (playerList.contains(player)){
            playerList.remove(player);
            player.sendMessage("§cVocê desativou o modo GOD.");
        }else{
            playerList.add(player);
            player.sendMessage("§aVocê ativou o modo GOD.");
            player.chat("/heal");
        }
    }
}
