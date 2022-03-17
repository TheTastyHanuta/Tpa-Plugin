package az.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import az.main.Mainclass;

public class TpaCancel implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player) {
		
		Player p = (Player) sender;	
		
		if(args.length == 1) {
			Player p2 = Bukkit.getPlayer(args[0]);
			
			try {
				Player p3 = Mainclass.tpa.get(p2);
				if(p3 != p) {
					p.sendMessage(Mainclass.prefix + "§cDu hast keine Anfrage verschickt!");
					return false;
				}
			}catch(Exception ex){
				p.sendMessage(Mainclass.prefix + "§c Du hast keine Anfrage verschickt!");
			}
			
			
			if(Mainclass.tpa.isEmpty()) {
				p.sendMessage(Mainclass.prefix + "§cDu hast keine Anfrage verschickt!");
			}else {
				try {
					Mainclass.tpa.remove(p2, p);
					p.sendMessage(Mainclass.prefix + "§cDu hast die Anfrage erfolgreich abgebrochen!");
					p2.sendMessage(Mainclass.prefix  + "§cDie Anfrage von §a" + p.getName() +"§c wurde abgebrochen!");
				}catch (Exception ex) {
					p.sendMessage(Mainclass.prefix + "§cDu hast keine Anfrage verschickt!");
				}
			}

		}else {
			p.sendMessage(Mainclass.prefix + "§cGib bitte den Namen des Spielers mit an!");
		}	
		}
		return false;
		
	
	}
}
