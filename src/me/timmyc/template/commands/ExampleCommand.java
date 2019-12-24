package me.timmyc.template.commands;

import me.timmyc.template.MainClass;
import me.timmyc.template.utilities.Utilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ExampleCommand implements CommandExecutor {
    //Classes
    private MainClass plugin; //Instance of the main class
    public ExampleCommand(MainClass mainClass) {this.plugin = mainClass;} //Initializing the main class

    private Utilities utilities; //Instance of the Utilities class
    public ExampleCommand(Utilities utilities) {this.utilities = utilities;} //Initializing the Utilities class

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        //Command code goes here with return statement
        return true;
    }
}
