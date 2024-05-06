package pt.joelcosta.stautomessage.managers;

import org.bukkit.configuration.file.FileConfiguration;
import pt.joelcosta.stautomessage.Main;

import java.util.List;
import java.util.stream.Collectors;

public class ConfigManager {

    private Main instance = Main.getInstance();
    public ConfigManager() {
    }

    public List<String> getMessagesFromConfig(){
        FileConfiguration config = instance.getConfig();
        return getColouredList(config.getStringList("Messages"));
    }

    private List<String> getColouredList(List<String> listToColor){
        return listToColor.stream().map(s -> s.replace("&", "§")).collect(Collectors.toList());
    }
}
