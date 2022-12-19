package br.com.stency.essentials.commands;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Aliases;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import com.google.common.collect.Lists;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class FlyCommand extends CommonCommand {

    @Getter
    private static List<Player> playerList = Lists.newArrayList();

    @Command("fly")
    @Aliases("voar")
    @Permission("stency.commands.fly")
    @Override
    public void command(CommandSender commandSender, Player player, String[] strings) {
        if (playerList.contains(player)){
            playerList.remove(player);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.sendMessage("§cVocê desativou o modo voar.");
        }else{
            playerList.add(player);
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage("§aVocê ativou o modo voar.");
        }
    }
}
