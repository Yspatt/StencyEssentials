package br.com.stency.essentials.listener;

import br.com.stency.essentials.commands.GodCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void damage(EntityDamageEvent e){
        if (e.getEntity() instanceof Player){
            Player player = (Player)e.getEntity();
            if (GodCommand.getPlayerList().contains(player)){
                e.setCancelled(true);
            }
        }
    }
}
