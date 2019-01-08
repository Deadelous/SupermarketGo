package Websocket;

import CommunicationShared.CommunicatorWebSocketMessage;
import CommunicationShared.CommunicatorWebSocketMessageOperation;
import Model.*;
import Repository.AccountRepository;
import WebsocketClient.CommunicatorMessage;
import com.google.gson.Gson;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessagingLogic {

    private static MessagingLogic instance;
    public static MessagingLogic getInstance() {
        if (instance == null) {
            instance = new MessagingLogic();
        }
        return instance;
    }

    private HashMap<String, UserSession> userSessions = new HashMap<>();
    private Gson gson = new Gson();

    private MessagingLogic() {
    }

    public void receiveText(UserSession session, String text) {
        try {
            receiveData(session, gson.fromJson(text, data.class));
        } catch (Throwable t) {
        }
    }

    private void receiveData(UserSession session, data data) {
        if (data == null) return;

        // for all operation except login, do session checking
        if (data.operation != data.AUTHENTICATION_LOGIN) {
            if (!validateSession(data.session)) {
                session.disconnect(401, "Invalid session");
            }
        }

        switch (data.operation) {
            case Websocket.data.AUTHENTICATION_LOGIN:
                login(session, data.user);
                break;
            case Websocket.data.MESSAGING_SEND:
                send(data.message);
                break;
            default:
                session.disconnect(404, "Wrong operation");
        }
    }

    private void login(UserSession session, user user) {
        if (user == null) {
            session.disconnect(401, "Give username and password!");
        }

        if (dataRepository.getInstance().isValid(user)) {
            userSessions.put(user.username, session);

            session.setCurrentUser(user);

            data data = new data();
            data.operation = data.AUTHENTICATION_LOGIN;
            data.session = dataRepository.getInstance().DUMMY_SESSION;

            try {
                session.receiveText(gson.toJson(data));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            session.disconnect(401, "Wrong username or password!");
        }
    }

    private boolean validateSession(String session) {
        return dataRepository.getInstance().isValid(session);
    }

    private void send(message message) {
        if (isUserOnline(message.to)) {
            System.out.println("User is online, try to send message");
            UserSession userSession = userSessions.get(message.to);
            try {
                userSession.receiveText(gson.toJson(message));
            } catch (Exception ex) {
                // put to offline message
                System.out.println("User is offline");
            }
        } else {
            // todo put to offline message
            System.out.println("User is offline");
        }
    }

    private boolean isUserOnline(String username) {
        return userSessions.containsKey(username);
    }

    public void setOffline(String username) {
        userSessions.remove(username);
        System.err.println("Set "+username+" offline.");
    }

}


