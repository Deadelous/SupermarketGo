package Websocket;

public interface UserSession {
    void receiveText(String text) throws Exception;
    void setCurrentUser(user user);
    void disconnect(int status, String reason);
}
