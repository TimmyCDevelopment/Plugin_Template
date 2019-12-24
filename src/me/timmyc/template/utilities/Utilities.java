package me.timmyc.template.utilities;

import com.google.common.io.ByteStreams;
import me.timmyc.template.MainClass;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Utilities {

    private MainClass plugin; //Instance of the main class
    public Utilities(MainClass plugin) { this.plugin = plugin; } //Initializing the main class

    //ThirtyVirus' config code
    public static File loadResource(Plugin plugin, String resource){
        File folder = plugin.getDataFolder();
        if(!folder.exists()){
            folder.mkdir();
        }
        File resourceFile = new File(folder, resource);
        try {
            if(!resourceFile.exists()){
                resourceFile.createNewFile();
                try(InputStream in = plugin.getResource(resource);
                    OutputStream out = new FileOutputStream(resourceFile)){
                    ByteStreams.copy(in, out);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resourceFile;
    }
}
