package me.oyuncozucu.specialitems.listeners;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Listener implements org.bukkit.event.Listener {

    private List<UUID> vanish = new ArrayList<>();
    List<FallingBlock> throwedtnt = new ArrayList<>();

    @EventHandler
    public void onSnake(PlayerToggleSneakEvent e) {

        Player player = e.getPlayer();

        if (vanish.contains(player.getUniqueId())) {
            vanish.remove(player.getUniqueId());

            for (Player target : Bukkit.getOnlinePlayers()) {
                target.showPlayer(player);

            }
            player.sendMessage(ChatColor.GREEN + "Görünürsün");


        } else {
            vanish.add(player.getUniqueId());
            for (Player target : Bukkit.getOnlinePlayers()) {
                target.hidePlayer(player);
            }
            player.sendMessage(ChatColor.GREEN + "Gizlisin");

        }
    }

    @EventHandler
    public void onArrow(ProjectileHitEvent e) {

        if (e.getEntity().getType() == EntityType.ARROW) {
            if (e.getEntity().getShooter() instanceof Player) {
                Player player = (Player) e.getEntity().getShooter();

                ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
                if (itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Işınlayıcı Yay")) {

                    Location location = e.getEntity().getLocation();
                    player.teleport(location);
                    e.getEntity().remove();
                    player.sendMessage(ChatColor.GREEN + "Işınlandın!");
                    player.playSound(location, Sound.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F);

                }

            }
        }

    }

    @EventHandler
    public void onDiamondStick(BlockBreakEvent e) {

        Player player = e.getPlayer();

        ItemStack itemMainHand = player.getInventory().getItemInMainHand();
        if (itemMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Sihirli Çubuk")) {

            ItemStack elmas = new ItemStack(Material.DIAMOND, 1);
            e.getBlock().getLocation().getWorld().dropItem(e.getBlock().getLocation(), elmas);
            e.setDropItems(false);

        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "BUILDER BALTA")) {
            World world = player.getWorld();
            if (world.getSpawnLocation().getBlock().getType() == Material.AIR) {
                Location l = player.getLocation();
                int x = l.getBlockX();
                int y = l.getBlockY() - 1;
                int z = l.getBlockZ();
                int floorRadius = 2;
                for (int xCoord = x - floorRadius; xCoord < x + floorRadius; xCoord++)
                    for (int zCoord = z - floorRadius; zCoord < z + floorRadius; zCoord++)
                        player.sendBlockChange(new Location(world, xCoord, y, zCoord), Material.BEDROCK, (byte) 0);
            }
        }

    }

    @EventHandler
    public void onGun(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(ChatColor.YELLOW + "TNT SİLAHI")) {
            FallingBlock tnt = e.getPlayer().getWorld().spawnFallingBlock(e.getPlayer().getEyeLocation(), Material.TNT, (byte) 0);
            tnt.setDropItem(false);
            throwedtnt.add(tnt);
            tnt.setVelocity(e.getPlayer().getLocation().getDirection().multiply(3));
            e.setCancelled(true);

        }
    }
    @EventHandler
    public void onFall(EntityChangeBlockEvent e) {

        if (e.getEntity() instanceof FallingBlock) {
            if (throwedtnt.contains(e.getEntity())) {
                e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), 5,false,false);
                e.setCancelled(true);
                e.getEntity().remove();


            }
        }

    }
    @EventHandler
    public void onEggGun(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Yumurta Silahı")) {

            player.launchProjectile(Egg.class, player.getPlayer().getEyeLocation().getDirection());

        }

    }
}
