package com.matthew.villagerTraderPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import revxrsal.commands.annotation.Command;

import java.util.ArrayList;
import java.util.List;

public class SpawnTrader {

    @Command("spawntrader")
    public void spawnTrader(Player player) {

        Location loc = player.getLocation();
        Villager trader = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
        trader.setCustomName(ChatColor.AQUA + "SpecialTrader");
        trader.setCustomNameVisible(true);
        trader.setAI(false);
        // Save UUID to TraderStorage
        player.sendMessage("Special Trader Spawned!");
        List<MerchantRecipe> trades = new ArrayList<>();
        // Create the trade: 1 Ender Dragon Egg for 1 Special Potion
        MerchantRecipe trade = new MerchantRecipe(createSpecialPotion(), 9999); // Max uses of trade
        trade.addIngredient(new ItemStack(Material.DRAGON_EGG)); // The required item (Ender Dragon Egg)
        trades.add(trade);
        // Open the trade window for the player
        trader.setRecipes(trades);
    }

    public ItemStack createSpecialPotion() {
        // Create a basic potion item
        ItemStack potion = new ItemStack(Material.POTION);

        // Get the potion meta
        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
        // Set custom name for the potion
        potionMeta.setDisplayName("Potion of Power");  // adds color (purple in this case)

        // Add lore (description) for the potion
        List<String> lore = new ArrayList<>();
        lore.add("Drink to gain special powers!");
        lore.add("Contains the essence of an Ender Dragon Egg.");
        potionMeta.setLore(lore);

        // Add custom potion effects (effect, duration, amplifier)
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1), true);  // Strength II for infinite duration
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1), true);            // Speed II for infinite duration
        potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1), true);     // Regeneration II for infinite duration  // Regeneration II for 1 minute

        // Apply the meta to the potion
        potion.setItemMeta(potionMeta);

        return potion;
    }
}
