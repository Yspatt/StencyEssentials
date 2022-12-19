package br.com.stency.essentials.listener;

import br.com.stency.essentials.commands.GodCommand;
import br.com.stency.essentials.commands.tpa.TpaCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void quit(PlayerQuitEvent e){
        e.setQuitMessage(null);
        TpaCommand.getPlayerMap().remove(e.getPlayer());
        GodCommand.getPlayerList().remove(e.getPlayer());
    }
}
