package az.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import az.main.Mainclass;

public class TpaAccept implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player) {
		
		Player p = (Player) sender;
		
		if(args.length == 0) {
			
			try {
			
			Player p2 = Mainclass.tpa.get(p);
			
			p2.teleport(p.getLocation());
			
			p.sendMessage(Mainclass.prefix + "§aTeleportation war erfolgreich!");
			
			p2.sendMessage(Mainclass.prefix + "§aTeleportation war erfolgreich!");
			
			Mainclass.tpa.remove(p, p2);
			}catch(Exception ex){
				p.sendMessage(Mainclass.prefix + "§cDu hast keine Anfrage!");
			}
			
		}
		else {
			p.sendMessage(Mainclass.prefix + " §c/tpaaccept");
		}
			
		}
		return false;
	}

}
