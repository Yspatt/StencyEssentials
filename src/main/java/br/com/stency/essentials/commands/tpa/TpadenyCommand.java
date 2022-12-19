package br.com.stency.essentials.commands.tpa;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Aliases;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpadenyCommand extends CommonCommand {

    @Command("tpanegar")
    @Aliases("tpadeny")
    @Permission("")
    @Override
    public void command(CommandSender commandSender, Player player, String[] arguments) {
        if (arguments.length == 0){
            player.sendMessage("§cUse /tpanegar (player).");
        }else{
            Player target = Bukkit.getPlayer(arguments[0]);
            if (target == null){
                player.sendMessage("§cEste jogador não está online.");
            }else {
                if (TpaCommand.getPlayerMap().containsKey(target) && TpaCommand.getPlayerMap().get(target).equals(player)) {
                    TpaCommand.getPlayerMap().remove(target);
                    player.sendMessage("");
                    player.sendMessage("§cVocê recusou o pedido de teleporte de §f" + target.getName() + "§a.");
                    player.sendMessage("");

                    target.sendMessage("");
                    target.sendMessage("§cO jogador §f" + player.getName() + "§c recusou seu pedido de teleporte.");
                    target.sendMessage("");
                } else {
                    player.sendMessage("§cEste jogador não lhe enviou nenhum pedido de teleporte.");
                }
            }
        }
    }
}
