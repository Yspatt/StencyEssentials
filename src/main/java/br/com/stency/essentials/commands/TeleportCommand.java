package br.com.stency.essentials.commands;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Aliases;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand extends CommonCommand {

    @Command("tp")
    @Aliases({"teleport","teleportar"})
    @Permission("stency.commands.teleport")
    @Override
    public void command(CommandSender commandSender, Player player, String[] arguments) {
        if (arguments.length == 0){
            player.sendMessage("§cUse /tp (player) (player)");
        }else{
            if (arguments.length == 1){
                Player target = Bukkit.getPlayer(arguments[0]);
                if (target != null){
                    player.teleport(target.getLocation());
                    player.sendMessage("§aVocê se teleportou até §f" + target.getName() + "§a.");
                }else{
                    player.sendMessage("§cEste jogador não está online.");
                }
            }else if (arguments.length == 2){
                Player target1 = Bukkit.getPlayer(arguments[0]);
                Player target2 = Bukkit.getPlayer(arguments[1]);
                if (target1 != null && target2 != null){
                    target1.teleport(target2.getLocation());
                    player.sendMessage("§aVocê teleportou §f" + target1.getName() + "§a até §f" + target2.getName() + "§a.");
                }else{
                    player.sendMessage("§cEste jogador não está online.");
                }
            }else if (arguments.length == 3){
                if (isDouble(arguments[0]) && isDouble(arguments[1]) && isDouble(arguments[2])){
                    Location location = new Location(player.getWorld(),Double.parseDouble(arguments[0]),Double.parseDouble(arguments[1]),Double.parseDouble(arguments[2]));
                    player.teleport(location);
                    player.sendMessage("§aTeleportado(a)!");
                }else{
                    player.sendMessage("§cUse /tp (player) (player).");
                }
            }
        }
    }

    private boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
