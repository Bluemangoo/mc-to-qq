/**
 * @Author: Bluemangoo
 * @date: 2022.04
 * @Copyright: 2022 Bluemangoo. All rights reserved.
 * @Description: socket message
 */
package net.bluemangoo.socket;

public class Message {
    private final int clientID;
    private final String msg;
    public int getClientID() {
        return clientID;
    }
    public String getMsg() {
        return msg;
    }
    public Message(int clientID,String msg){
        this.clientID=clientID;
        this.msg=msg;

    }
}
