package me.oyuncozucu.specialitems.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {

    public static ItemStack bowItem(Player player) {

        ItemStack bow = new ItemStack(Material.BOW);

        ItemMeta bow_ = bow.getItemMeta();
        bow_.setDisplayName(ChatColor.RED+ "Işınlayıcı Yay");
        bow_.addEnchant(Enchantment.ARROW_INFINITE,1,false);
        bow_.setUnbreakable(true);
        bow.setItemMeta(bow_);

        return bow;

    }
    public static ItemStack diamondStack(Player player) {

        ItemStack stack = new ItemStack(Material.STICK);

        ItemMeta stack_ = stack.getItemMeta();
        stack_.setDisplayName(ChatColor.AQUA+"Sihirli Çubuk");
        stack_.setUnbreakable(true);
        stack.setItemMeta(stack_);


        return stack;
    }
    public static ItemStack buildWand(Player player) {

        ItemStack balta = new ItemStack(Material.IRON_AXE);

        ItemMeta balta_ = balta.getItemMeta();
        balta_.setDisplayName(ChatColor.GREEN+"BUILDER BALTA");
        balta_.setUnbreakable(true);
        balta.setItemMeta(balta_);


        return balta;
    }
    public static ItemStack tntGun(Player player) {

        ItemStack tnt = new ItemStack(Material.BLAZE_ROD);

        ItemMeta tnt_ = tnt.getItemMeta();
        tnt_.setDisplayName(ChatColor.YELLOW + "TNT SİLAHI");
        tnt_.setUnbreakable(true);
        tnt.setItemMeta(tnt_);

        return tnt;
    }
    public static ItemStack eggGun(Player player) {

        ItemStack egg = new ItemStack(Material.WOODEN_HOE);

        ItemMeta egg_ = egg.getItemMeta();
        egg_.setDisplayName(ChatColor.LIGHT_PURPLE + "Yumurta Silahı");
        egg_.setUnbreakable(true);
        egg.setItemMeta(egg_);

        return egg;
    }



}
