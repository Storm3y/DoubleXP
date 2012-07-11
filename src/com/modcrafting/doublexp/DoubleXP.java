package com.modcrafting.doublexp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DoubleXP extends JavaPlugin implements Listener{
	boolean toggleon = false;
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		if(!(event.getEntity() instanceof Player) && toggleon){
			event.setDroppedExp(event.getDroppedExp()*2);
		}
	}
	public boolean onCommand(CommandSender sender, Command command, String lab, String[] args) {
		if(sender.hasPermission("doublexp.use")){
			if(toggleon){
				toggleon = false;
				sender.sendMessage(ChatColor.RED+"DoubleXP is Disabled.");
			}else{
				toggleon = true;
				sender.sendMessage(ChatColor.GREEN+"DoubleXP is Enabled.");
			}
		}
		return true;
	}
}
