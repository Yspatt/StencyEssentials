package br.com.stency.essentials;

import br.com.stency.common.helpers.CommonPlugin;
import br.com.stency.essentials.commands.*;
import br.com.stency.essentials.commands.tpa.TpaCommand;
import br.com.stency.essentials.commands.tpa.TpacceptCommand;
import br.com.stency.essentials.commands.tpa.TpadenyCommand;
import br.com.stency.essentials.listener.EntityDamageListener;
import br.com.stency.essentials.listener.FoodLevelChangeListener;
import br.com.stency.essentials.listener.PlayerJoinListener;
import br.com.stency.essentials.listener.PlayerQuitListener;
import lombok.Getter;

public class Essentials extends CommonPlugin {

    @Getter
    private static Essentials instance;

    public Essentials(){
        instance = this;
    }


    @Override
    public void enable() {
        register(this,new GamemodeCommand(),new TeleportCommand(),new TpaCommand(),new TpacceptCommand(),new TpadenyCommand(),new EnchantCommand(),new FlyCommand(),new GodCommand(),new HealCommand(),new SpeedCommand());
        register(this,new PlayerJoinListener(),new PlayerQuitListener(),new EntityDamageListener(),new FoodLevelChangeListener());

    }

    @Override
    public void disable() {

    }

    @Override
    public void load() {

    }
}
