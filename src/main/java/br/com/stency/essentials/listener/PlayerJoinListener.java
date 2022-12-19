package br.com.stency.essentials.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e){
        e.setJoinMessage(null);
        e.getPlayer().chat("/spawn");
    }
}
