package com.bwfcwalshy.sgcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ChatAnnouncment implements CommandExecutor {
	
	private boolean isDisabled = false;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(isDisabled == true){
			if(cmd.getName().equalsIgnoreCase("chatannouncment")){
				
				sender.sendMessage(ChatColor.RED + "Chat disabled");
				
				isDisabled = false;				
			}
		}
		if(isDisabled == false){
			if(cmd.getName().equalsIgnoreCase("chatannouncment")){
				
				sender.sendMessage(ChatColor.GREEN + "Chat enabled");
				
				isDisabled = true;
			}
		}
		return isDisabled;
	}
	
	@EventHandler
	private void onPlayerJoin(PlayerJoinEvent e){
		if(isDisabled == true){
			e.setJoinMessage("");
		}
	}
	
	@EventHandler
	private void onPlayerQuit(PlayerQuitEvent e){
		if(isDisabled == true){
			e.setQuitMessage("");
		}
	}
}
