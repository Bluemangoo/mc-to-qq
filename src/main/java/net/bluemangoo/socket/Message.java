/**
 * @Author: Bluemangoo
 * @date: 2022.04
 * @Copyright: 2022 Bluemangoo. All rights reserved.
 * @Description: socket message
 */
package net.bluemangoo.socket;

public class Message {
    private final int from;
    private final String msg;

    public Message(int from, String msg) {
        this.from = from;
        this.msg = msg;

    }

    public int getClientID() {
        return from;
    }

    public String getMsg() {
        return msg;
    }
}
