package pt.joelcosta.stautomessage.managers;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MessageManager {
    private List<String> messages;
    private Random random;

    private int TIME_UNTIL_SEND_MESSAGE = 3;
    private long currentTime;

    public MessageManager() {
        ConfigManager configManager = new ConfigManager();
        this.messages = configManager.getMessagesFromConfig();
        random = new Random();
        currentTime = System.currentTimeMillis();
    }

    public void sendMessage(){
        int messageSize = messages.size();
        String messageToSend = messages.get(random.nextInt(messageSize));
        Bukkit.broadcastMessage(messageToSend);
    }

    public boolean canSendMessage(){
        return System.currentTimeMillis() >= currentTime + TimeUnit.SECONDS.toMillis(TIME_UNTIL_SEND_MESSAGE);
    }
}
