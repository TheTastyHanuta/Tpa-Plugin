package az.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import az.commands.Tpa;
import az.commands.TpaAccept;
import az.commands.TpaDeny;


public class Mainclass extends JavaPlugin{
	
	public static String prefix = "§8[§3Server§8] ";
	public static String noPerm = prefix + "§cDu hast keine Rechte dazu!";
	public static HashMap<Player, Player> tpa = new HashMap<Player, Player>();


	public void onEnable(){
		Bukkit.getConsoleSender().sendMessage(prefix+ "§7enabled");
		this.getCommand("tpa").setExecutor(new Tpa());
		this.getCommand("tpaccept").setExecutor(new TpaAccept());
		this.getCommand("tpadeny").setExecutor(new TpaDeny());

	}
	
	public void onDisable(){
		Bukkit.getConsoleSender().sendMessage(prefix+ "§7disabled");
	}

}

