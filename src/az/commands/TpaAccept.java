package az.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import az.main.Mainclass;

public class TpaAccept implements CommandExecutor{
	
	private HashMap<Player, Location> lastLoc = new HashMap<>(); 
	private HashMap<Player, Location> lastLoc2 = new HashMap<>(); 
	private Plugin plugin = Mainclass.getPlugin(Mainclass.class);
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player) {
			
		
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			
			try {
			
			Player p2 = Mainclass.tpa.get(p);
			
			p2.sendMessage(Mainclass.prefix+ "§aTeleportation erfolgt. §cNicht bewegen...");
			p.sendMessage(Mainclass.prefix + "§aTeleportation erfolgt. §cNicht bewegen...");
			lastLoc.put(p, p.getLocation());
			lastLoc2.put(p2, p2.getLocation());
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
	               public void run() {
	            	   Location Playerone =lastLoc.get(p);
            		   Location Playertwo =lastLoc2.get(p2);
            		   
            		   Double distance1 = Playerone.distance(p.getLocation());
            		   Double distance2 = Playertwo.distance(p2.getLocation());
            		   
            		   if((distance1==0.0)&&(distance2==0.0)) {
            			   try {
    	            		   
       	            		
    	            		   Player p3 = Mainclass.tpa.get(p);
    		            	   
    		            	   p3.teleport(p.getLocation());
    							
    							p.sendMessage(Mainclass.prefix + "§aTeleportation war erfolgreich!");
    							
    							p3.sendMessage(Mainclass.prefix + "§aTeleportation war erfolgreich!");
    							Mainclass.tpa.remove(p, p2);
    						
    					} catch (Exception ex) {
    						p.sendMessage(Mainclass.prefix + "§aDie Anfrage wurde abgebrochen!");
    					}
            			   
            		   }else {
            			   p.sendMessage(Mainclass.prefix + "§cEiner von euch hat sich bewegt!");
            			   p2.sendMessage(Mainclass.prefix + "§cEiner von euch hat sich bewegt!");
            		   }
            		   	          	           	   	            	             	   	            	   
	               }
	            }, 100L);
			
			
			}catch(Exception ex){
				
			}
			
		}
		else {
			p.sendMessage(Mainclass.prefix + " §c/tpaaccept");
		}
			
		}
		return false;
	}

}
