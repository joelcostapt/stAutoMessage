package pt.joelcosta.stautomessage.task;

import org.bukkit.scheduler.BukkitRunnable;
import pt.joelcosta.stautomessage.managers.MessageManager;

public class MessageTask extends BukkitRunnable {
    private MessageManager messageManager;
    public MessageTask(MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    @Override
    public void run() {
        if (messageManager.canSendMessage()){
            messageManager.sendMessage();
        }
    }
}
