/**
 * @Author: Bluemangoo
 * @date: 2022.04
 * @Copyright: 2022 Bluemangoo. All rights reserved.
 * @Description: get message event for socket server
 */
package net.bluemangoo.socket.event;

import net.bluemangoo.socket.Message;
import net.bluemangoo.socket.Server;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Collection;
import java.util.EventListener;

public class GetMSGServer extends Event {
    private static final HandlerList handlers = new HandlerList();
    Message msg;

    public class MSGManager {
        private Collection<GetMSGListener> listeners;
    }
    public GetMSGServer(Message msg) {
        this.msg=msg;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Message getMsg() {
        return msg;
    }

}




