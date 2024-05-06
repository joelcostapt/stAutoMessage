package pt.joelcosta.stautomessage;

import org.bukkit.plugin.java.JavaPlugin;
import pt.joelcosta.stautomessage.managers.MessageManager;
import pt.joelcosta.stautomessage.task.MessageTask;

public final class Main extends JavaPlugin {

    private static Main instance;
    private MessageManager messageManager;
    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        messageManager = new MessageManager();

        new MessageTask(messageManager).runTaskTimer(this, 0, getConfig().getLong("Delay") * 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }
}
