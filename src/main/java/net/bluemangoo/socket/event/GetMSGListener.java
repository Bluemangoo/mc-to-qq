/**
 * @Author: Bluemangoo
 * @date: 2022.04
 * @Copyright: 2022 Bluemangoo. All rights reserved.
 * @Description:
 */
package net.bluemangoo.socket.event;

import java.util.EventListener;

/**
 * 定义监听接口，负责监听事件
 */
public interface GetMSGListener extends EventListener {
    public void getMSGEvent(GetMSGServer event);
}