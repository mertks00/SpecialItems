package me.oyuncozucu.specialitems.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MobDrop implements Listener {

    @EventHandler
    public void onDeathEntity(EntityDeathEvent e) {

        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName(ChatColor.RED+ "Işınlayıcı Yay");
        item_meta.addEnchant(Enchantment.ARROW_INFINITE,1,false);
        item.setItemMeta(item_meta);

        ItemStack arrow = new ItemStack(Material.ARROW, 1);

        if (e.getEntity() instanceof WitherSkeleton) {
            e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(item));
            e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(arrow));
        }

    }

}
