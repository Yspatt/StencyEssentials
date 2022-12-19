package br.com.stency.essentials.commands;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Aliases;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand extends CommonCommand {

    @Command("speed")
    @Aliases("velocidade")
    @Permission("stency.commands.speed")
    @Override
    public void command(CommandSender commandSender, Player player, String[] arguments) {
        if (arguments.length == 0){
            player.sendMessage("§cUse /speed (speed (use 'reset' para voltar ao normal)).");
        }else{
            if (arguments[0].equalsIgnoreCase("reset")){
                player.setWalkSpeed(0.2f);
                player.setFlySpeed(0.1f);
                player.sendMessage("§aVocê resetou sua velocidade.");
            }else {
                if (isDouble(arguments[0])) {
                    if (Double.parseDouble(arguments[0]) < 0 || Double.parseDouble(arguments[0]) > 10) {
                        player.sendMessage("§cA velocidade não pode ser maior que 10 e menor que 0.");
                    } else {
                        String type = "";
                        if (!player.isFlying()) {
                            player.setWalkSpeed((float) speed(Float.parseFloat(arguments[0])));
                            type = "caminhada";
                        } else {
                            player.setFlySpeed((float) speed(Float.parseFloat(arguments[0])));
                            type = "voar";
                        }
                        player.sendMessage("§aVocê definiu sua velocidade de " + type + " para " + arguments[0] + ".");
                        player.sendMessage("§7(Use /speed reset para resetar sua velocidade)");
                    }
                } else {
                    player.sendMessage("§cEspecifique um número válido.");
                }
            }
        }

    }

    public double speed(float level){
       return level/10;
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
