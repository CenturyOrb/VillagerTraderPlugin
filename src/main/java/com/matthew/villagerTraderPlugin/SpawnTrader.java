package com.matthew.villagerTraderPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.PotionMeta;
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
        trader.setInvulnerable(true);
        trader.setAI(false);
        // Save UUID to TraderStorage
        player.sendMessage("Special Trader Spawned!");
        List<MerchantRecipe> trades = new ArrayList<>();
        // Create the trade: 1 Ender Dragon Egg for 1 Special Potion
        MerchantRecipe trade = new MerchantRecipe(createLeaprootConcoction(), 9999); // Max uses of trade
        trade.addIngredient(new ItemStack(Material.DRAGON_EGG)); // The required item (Ender Dragon Egg)
        trades.add(trade);
        // Open the trade window for the player
        trader.setRecipes(trades);
    }

    public ItemStack createLeaprootConcoction() {
        // Create a basic potion item
        ItemStack potion = new ItemStack(Material.POTION);

        // Get the potion meta
        PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();

        // Set custom name for the potion
        potionMeta.setDisplayName(ChatColor.RED + "Leaproot Concoction");

        // Add lore (description) for the potion
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "A mysterious potion");
        lore.add("");
        lore.add(ChatColor.GREEN + "- Grants ability to leap");
        potionMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        potionMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        potionMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        potionMeta.setLore(lore);

        potion.setItemMeta(potionMeta);

        return potion;
    }
}
