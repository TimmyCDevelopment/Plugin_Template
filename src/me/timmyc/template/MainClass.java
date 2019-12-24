package me.timmyc.template;

import me.timmyc.template.commands.ExampleCommand;
import me.timmyc.template.events.ExampleEvent;
import me.timmyc.template.utilities.Utilities;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class MainClass extends JavaPlugin {

    private Utilities utils; //Instance of the Utilities class

    //custom settings
    public static String prefix = "&e[&4Template&e] &r"; //Plugin prefix
    public static String consolePrefix = "[Template]"; //Plugin console prefix

    @Override
    public void onEnable(){
        //Initializing the Utilities class
        utils = new Utilities(this);
        loadConfig();

        getCommand("template").setExecutor(new ExampleCommand(this));
        getServer().getPluginManager().registerEvents(new ExampleEvent(), this);
    }

    public void loadConfig(){
        File configFile = new File(getDataFolder(), "config.yml");
        if(!configFile.exists()){
            utils.loadResource(this, "config.yml");
        }
        FileConfiguration cfg = this.getConfig();
        prefix = getConfig().getString("plugin-prefix");
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("plugin-prefix"));
    }
}
