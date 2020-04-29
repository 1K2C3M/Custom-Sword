package me.Corey.CustomItem;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// /sword
		if (label.equalsIgnoreCase("sword")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Seriously... not like you can do anything with this sword.");
				return true;
			}
			Player player = (Player) sender;
			if (player.getInventory().firstEmpty() == -1) {
				// inventory is full
				Location loc = player.getLocation();
				World world = player.getWorld();
				
				world.dropItemNaturally(loc, getitem());
				player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Go slay your enemies.. but pick up the sword first!");
				return true;
			}
			player.getInventory().addItem(getitem());
			player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Go slay your enemies");
			return true;
 		}
		return false;
	}
	
	
	public ItemStack getitem() {
		
		ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = sword.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Soul Crusher");
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.RED + "" + ChatColor.ITALIC + "Destroy the souls of your enemies");
		meta.setLore(lore);
		
		meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.setUnbreakable(true);
		
		sword.setItemMeta(meta);
		
		return sword;
		
	}

	
}
