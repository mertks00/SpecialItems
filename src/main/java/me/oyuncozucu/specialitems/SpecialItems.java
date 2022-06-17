package me.oyuncozucu.specialitems;

import me.oyuncozucu.specialitems.commands.GiveCommand;
import me.oyuncozucu.specialitems.listeners.Listener;
import me.oyuncozucu.specialitems.listeners.MobDrop;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpecialItems extends JavaPlugin {

    @Override
    public void onEnable() {

        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.AQUA+"Sihirli Çubuk");
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        ItemStack balta = new ItemStack(Material.IRON_AXE);
        ItemMeta balta_ = balta.getItemMeta();
        balta_.setDisplayName(ChatColor.GREEN+"BUILDER BALTA");
        balta_.setUnbreakable(true);
        balta.setItemMeta(balta_);

        ItemStack egg = new ItemStack(Material.WOODEN_HOE);
        ItemMeta egg_ = egg.getItemMeta();
        egg_.setDisplayName(ChatColor.LIGHT_PURPLE + "Yumurta Silahı");
        egg_.setUnbreakable(true);
        egg.setItemMeta(egg_);

        ItemStack tnt = new ItemStack(Material.BLAZE_ROD);
        ItemMeta tnt_ = tnt.getItemMeta();
        tnt_.setDisplayName(ChatColor.YELLOW + "TNT SİLAHI");
        tnt_.setUnbreakable(true);
        tnt.setItemMeta(tnt_);

        ShapedRecipe egg_gun_craft = new ShapedRecipe(new NamespacedKey(this,"custom_egg_hoe"), new ItemStack(egg));
        egg_gun_craft.shape(
                "CCC",
                "CCC",
                "CCC");

        egg_gun_craft.setIngredient('C', Material.WOODEN_HOE);

        Bukkit.addRecipe(egg_gun_craft);

        ShapedRecipe tnt_craft = new ShapedRecipe(new NamespacedKey(this,"custom_tnt_gun"), new ItemStack(tnt));
        tnt_craft.shape(
                "RRR",
                "RBR",
                "RRR");

        tnt_craft.setIngredient('B', Material.BLAZE_ROD);
        tnt_craft.setIngredient('R', Material.GUNPOWDER);

        Bukkit.addRecipe(tnt_craft);

        ShapedRecipe balta_craft = new ShapedRecipe(new NamespacedKey(this,"custom_axe"), new ItemStack(balta));
        balta_craft.shape(
                "III",
                "IAI",
                "III");

        balta_craft.setIngredient('A', Material.IRON_AXE);
        balta_craft.setIngredient('I', Material.IRON_INGOT);

        Bukkit.addRecipe(balta_craft);


        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this,"custom_stick"), new ItemStack(itemStack));
        recipe.shape(
                "   ",
                " D ",
                " D ");

        recipe.setIngredient('D', Material.DIAMOND);

        Bukkit.addRecipe(recipe);
        getCommand("special").setExecutor(new GiveCommand());
        Bukkit.getPluginManager().registerEvents(new Listener(), this);
        Bukkit.getPluginManager().registerEvents(new MobDrop(), this);




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
