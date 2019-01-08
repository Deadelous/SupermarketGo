package Websocket;

public class data {
    public static final int AUTHENTICATION_LOGIN = 1;

    public static final int MESSAGING_SEND = 101;

    public int operation;
    public user user;
    public message message;
    public String session;
}
