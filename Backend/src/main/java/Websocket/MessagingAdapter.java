package Websocket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

public class MessagingAdapter extends WebSocketAdapter implements UserSession {

    private Session session;
    private user currentUser;

    @Override
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session);

        this.session = session;
    }
    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        MessagingLogic.getInstance().setOffline(currentUser.username);

        this.session = null;

        System.err.println("Close connection "+statusCode+", "+reason);

        super.onWebSocketClose(statusCode, reason);
    }
    @Override
    public void onWebSocketText(String message) {
        super.onWebSocketText(message);

        MessagingLogic.getInstance().receiveText(this, message);
    }
    @Override
    public void receiveText(String text) throws Exception {
        if (session != null && session.isOpen()) {
            session.getRemote().sendString(text);
        }
    }
    @Override
    public void setCurrentUser(user user) {
        this.currentUser = user;
    }
    @Override
    public void disconnect(int status, String reason) {

        session.close(status, reason);
        disconnect(status, reason);
    }

}