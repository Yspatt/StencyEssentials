package br.com.stency.essentials.commands;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Aliases;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class GamemodeCommand extends CommonCommand {

    @Command("gamemode")
    @Aliases("gm")
    @Permission("stency.commands.gamemode")
    @Override
    public void command(CommandSender commandSender, Player player, String[] arguments) {
        if (arguments.length == 0){
            player.sendMessage("§cUse /gamemode (0,1,2,3) (player)");
        }else{
            if (arguments.length == 1){
                if (isInteger(arguments[0])){
                    int number = Integer.parseInt(arguments[0]);
                    if (number > -1 && number < 4){
                        player.setGameMode(GameMode.getByValue(number));
                        player.sendMessage("§aVocê alterou o seu modo de jogo para §f" + GameMode.getByValue(number).name().toLowerCase() + "§a.");
                    }else{
                        player.sendMessage("§cUse /gamemode (0,1,2,3) (player)");
                    }
                }else{
                    player.sendMessage("§cUse /gamemode (0,1,2,3) (player)");
                }
            }else if (arguments.length == 2){
                if (isInteger(arguments[0])){
                    int number = Integer.parseInt(arguments[0]);
                    if (number > -1 && number < 4){
                        Player target = Bukkit.getPlayer(arguments[1]);
                        if (target != null) {
                            target.setGameMode(GameMode.getByValue(number));
                            player.sendMessage("§aVocê alterou o modo de jogo de §f" + target.getName() + "§a para §f" + GameMode.getByValue(number).name().toLowerCase() + "§a.");
                        }else{
                            player.sendMessage("§cEste jogador não está online.");
                        }
                    }else{
                        player.sendMessage("§cUse /gamemode (0,1,2,3) (player)");
                    }
                }else{
                    player.sendMessage("§cUse /gamemode (0,1,2,3) (player)");
                }
            }
        }
    }


    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
