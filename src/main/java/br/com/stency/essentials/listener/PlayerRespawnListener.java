package br.com.stency.essentials.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void respawn(PlayerRespawnEvent e){
        e.getPlayer().chat("/spawn");
    }
}
