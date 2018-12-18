package Websocket;

import Model.Account;
import Model.Message;

public class MessageData {
    public static final int AUTHENTICATION_LOGIN = 1;

    public static final int MESSAGING_SEND = 101;

    public int operation;
    public Account user;
    public Message message;
    public String session;
}
