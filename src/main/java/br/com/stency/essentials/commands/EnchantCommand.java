package br.com.stency.essentials.commands;

import br.com.stency.common.util.command.CommonCommand;
import br.com.stency.common.util.command.annotation.Aliases;
import br.com.stency.common.util.command.annotation.Command;
import br.com.stency.common.util.command.annotation.Permission;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;

public class EnchantCommand extends CommonCommand {

    @Command("enchant")
    @Aliases("encantar")
    @Permission("stency.commands.enchant")
    @Override
    public void command(CommandSender commandSender, Player player, String[] arguments) {
        if (arguments.length < 2){
            player.sendMessage("§cUse /enchant (encantamento) (nível)");
        }else{
            Enchantment enchantment = getEnchant(arguments[0].toLowerCase());
            if (enchantment == null){
                player.sendMessage("§cEste encantamento não existe.");
            }else{
                if (isInteger(arguments[1])){
                    if (player.getItemInHand() != null && player.getItemInHand().getType() != Material.AIR){
                        player.getItemInHand().addUnsafeEnchantment(enchantment,Integer.parseInt(arguments[1]));
                        player.sendMessage("§aVocê encantou o item com sucesso.");
                    }else{
                        player.sendMessage("§cVocê deve estar segurando algum item em sua mão.");
                    }
                }else{
                    player.sendMessage("§cInsira um número válido");
                }
            }
        }
    }


    public Enchantment getEnchant(String name){
        switch (name){
            case "sharpness":
                return Enchantment.DAMAGE_ALL;
            case "unbreaking":
                return Enchantment.DURABILITY;
            case "efficiency":
                return Enchantment.DIG_SPEED;
            case "fire_aspect":
                return Enchantment.FIRE_ASPECT;
            case "fire_protection":
                return Enchantment.PROTECTION_FIRE;
            case "protection":
                return Enchantment.PROTECTION_ENVIRONMENTAL;
            case "blast_protection":
                return Enchantment.PROTECTION_EXPLOSIONS;
            case "projectile_protection":
                return Enchantment.PROTECTION_PROJECTILE;
            case "feather_falling":
                return Enchantment.PROTECTION_FALL;
            case "respiration":
                return Enchantment.OXYGEN;
            case "aqua_affinity":
                return Enchantment.WATER_WORKER;
            case "thorns":
                return Enchantment.THORNS;
            case "depth_strider":
                return Enchantment.DEPTH_STRIDER;
            case "smite":
                return Enchantment.DAMAGE_UNDEAD;
            case "bane_of_arthropods":
                return Enchantment.DAMAGE_ARTHROPODS;
            case "knockback":
                return Enchantment.KNOCKBACK;
            case "looting":
                return Enchantment.LOOT_BONUS_MOBS;
            case "silk_touch":
                return Enchantment.SILK_TOUCH;
            case "fortune":
                return Enchantment.LOOT_BONUS_BLOCKS;
            case "power":
                return Enchantment.ARROW_DAMAGE;
            case "punch":
                return Enchantment.ARROW_KNOCKBACK;
            case "flame":
                return Enchantment.ARROW_FIRE;
            case "infinity":
                return Enchantment.ARROW_INFINITE;
            case "luck_of_the_sea":
                return Enchantment.LUCK;
            case "lure":
                return Enchantment.LURE;
        }
        return null;
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
