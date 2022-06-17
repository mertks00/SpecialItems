package me.oyuncozucu.specialitems.commands;

import me.oyuncozucu.specialitems.Colorize;
import me.oyuncozucu.specialitems.utils.ItemUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("specialitems.admin")) {
                if (args.length == 1 && args[0].equalsIgnoreCase("give")) {

                    ItemStack arrow = new ItemStack(Material.ARROW, 1);
                    player.getInventory().addItem(ItemUtil.bowItem(player));
                    player.getInventory().addItem(ItemUtil.diamondStack(player));
                    player.getInventory().addItem(ItemUtil.buildWand(player));
                    player.getInventory().addItem(ItemUtil.tntGun(player));
                    player.getInventory().addItem(ItemUtil.eggGun(player));
                    player.getInventory().addItem(arrow);
                    player.sendMessage(ChatColor.BLUE + "Itemları Aldın!");
                } else {
                    Colorize.format("&m&l------------------------------------------------");
                    Colorize.format("                                                    ");
                    Colorize.format(" &a-/special giveitems &7: &eItem Verir             ");
                    Colorize.format("                                                    ");
                    Colorize.format("&m&l------------------------------------------------");
                }

            } else {
                player.sendMessage(ChatColor.RED + "Buna izniniz yok.");
            }

        }

        return true;
    }
}
