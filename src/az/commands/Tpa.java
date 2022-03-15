package az.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import az.main.Mainclass;



public class Tpa implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player) {
			
		Player p = (Player)sender;
		Player p2 = Bukkit.getPlayer(args[0]);
		
		if(args.length == 1) 
		{
			if(p == p2) {
				p.sendMessage(Mainclass.prefix + "§cDu kannst dir nicht selber eine Anfrage schicken!");	
			}else if(p2 == null){
				p.sendMessage(Mainclass.prefix + "§cDer angegebene Spieler ist nicht online!");
			}else {
					Player p3 = Mainclass.tpa.get(p2);
					
					if(p3 != p) {						
				Mainclass.tpa.put(p2, p);
			 	
			p2.sendMessage(Mainclass.prefix + p.getName() + "§a m§chte sich zu dir teleportieren! Benutze §c/tpaaccept §aum die Anfrage anzunehmen oder §c/tpadeny §aum sie abzulehnen! Du hast 5 Minuten Zeit!");
			
			p.sendMessage(Mainclass.prefix + "§a" + p2.getName() + " hat die Anfrage bekommen! Nutze §c/tpacancel §8<Spielername>§a um sie abzubrechen!");
			
			new java.util.Timer().schedule(
					new java.util.TimerTask() {
						@Override
						public void run() {
							if(Mainclass.tpa.isEmpty()) {

							}else {
								Mainclass.tpa.remove(p2, p);
								p.sendMessage(Mainclass.prefix + "§cDeine Anfrage ist abgelaufen!");
								p2.sendMessage(Mainclass.prefix + "§cDie Anfrage ist abgelaufen!");
							}
						}
					},
					300000
				);
			}else {
				p.sendMessage(Mainclass.prefix + "§cDu hast bereits eine Anfrage verschickt! Nutze §a/tpacancel <Spielername>§c um sie abzubrechen!");
				return false;
			}
			}
		}
		else
		{
			p.sendMessage(Mainclass.prefix + "§cBitte benutze /tpa <SPIELER>!");
		}
		}
		return false;
	}

}
