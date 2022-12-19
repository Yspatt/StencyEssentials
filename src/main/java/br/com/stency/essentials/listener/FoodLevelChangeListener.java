package br.com.stency.essentials.listener;

import br.com.stency.essentials.commands.GodCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {

    @EventHandler
    public void hunger(FoodLevelChangeEvent e){
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (GodCommand.getPlayerList().contains(player)){
                e.setFoodLevel(20);
            }
        }
    }
}
