package br.com.stency.essentials.commands.tpa;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import br.com.stency.essentials.Essentials;
import com.google.common.collect.Maps;
import lombok.Getter;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class TpaCommand extends CommonCommand {

    @Getter
    private static Map<Player,Player> playerMap = Maps.newHashMap();


    @Command("tpa")
    @Permission("")
    @Override
    public void command(CommandSender commandSender, Player player, String[] arguments) {
        if (arguments.length == 0){
            player.sendMessage("§cUse /tpa (player).");
        }else{
            Player target = Bukkit.getPlayer(arguments[0]);
            if (target == null){
                player.sendMessage("§cEste jogador não está online.");
            }else{
                if (target.equals(player)){
                    player.sendMessage("§cVocê não pode se teleportar para você mesmo.");
                }else {
                    if (playerMap.containsKey(player)) {
                        player.sendMessage("§cVocê já tem um pedido de teleporte pendente.");
                    } else {
                        playerMap.put(player, target);
                        player.sendMessage("");
                        player.sendMessage("§e Você enviou um pedido de teleporte para §f" + target.getName() + "§e.");
                        player.sendMessage("");

                        target.sendMessage("§e O jogador §f" + player.getName() + "§e deseja se teletransportar até você");

                        TextComponent json_click = new TextComponent("§e Clique ");

                        TextComponent json_here = new TextComponent("§c§lAQUI");
                        json_here.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpanegar " + player.getName()));
                        json_here.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cClique para rejeitar").create()));

                        TextComponent json_here_2 = new TextComponent("§a§lAQUI");
                        json_here_2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaceitar " + player.getName()));
                        json_here_2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aClique para aceitar").create()));

                        json_click.addExtra(json_here_2);
                        json_click.addExtra("§e para aceitar ou clique ");
                        json_click.addExtra(json_here);
                        json_click.addExtra("§e para rejeitar.");

                        target.spigot().sendMessage(json_click);

                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                if (getPlayerMap().containsKey(player)) {
                                    getPlayerMap().remove(player);
                                    player.sendMessage("§cSeu pedido de teleporte para §f" + target.getName() + "§c esgotou...");
                                    target.sendMessage("§cO pedido de teleporte de §f" + player.getName() + "§c esgotou...");
                                }
                            }
                        }.runTaskLater(Essentials.getInstance(), 20 * 20);

                    }
                }
            }
        }
    }
}
