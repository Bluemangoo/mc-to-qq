/**
 * @Author: Bluemangoo
 * @date: 2022.04
 * @Copyright: 2022 Bluemangoo. All rights reserved.
 * @Description: get message event for socket server
 */
package net.bluemangoo.socket.event;

import net.bluemangoo.socket.Message;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Collection;

public class GetMSGServer extends Event {
    private static final HandlerList handlers = new HandlerList();
    final Message msg;

    public GetMSGServer(Message msg) {
        this.msg = msg;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public Message getMsg() {
        return msg;
    }

    public static class MSGManager {
        private Collection<GetMSGListener> listeners;
    }

}




