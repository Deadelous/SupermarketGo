package Websocket;

import CommunicationShared.CommunicatorWebSocketMessage;
import CommunicationShared.CommunicatorWebSocketMessageOperation;
import Model.Shop;
import WebsocketClient.CommunicatorMessage;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.websocket.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunicatorServerWebSocket {

    // All sessions
    public static final Map<Integer, Session> sessions = new HashMap<>();

    private Gson gson = new Gson();
    private static final Shop game = new Shop();
    private static Integer count = 0;

    // Map each property to list of sessions that are subscribed to that property
    private static final Map<String, List<Session>> propertySessions = new HashMap<>();


    @OnOpen
    public void onConnect(Session session) {
        System.out.println("[WebSocket Connected] SessionID: " + session.getId());
        String message = String.format("[New client with client side session ID]: %s", session.getId());
        if (sessions.size() == 2) {
            return;
        }
        sessions.put(count,session);
        count++;
        System.out.println("[#sessions]: " + sessions.size());
    }

    @OnMessage
    public void onText(String message, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + " [Received] : " + message);
        handleMessageFromClient(message, session);
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + " [Socket Closed]: " + reason);
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable cause, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + "[ERROR]: ");
        cause.printStackTrace(System.err);
    }

    private void handleMessageFromClient(String jsonMessage, Session session) {
        Gson gson = new Gson();
        CommunicatorWebSocketMessage wbMessage = null;
        System.out.println(jsonMessage);
        try {
            wbMessage = gson.fromJson(jsonMessage, CommunicatorWebSocketMessage.class);
        } catch (JsonSyntaxException ex) {
            System.out.println("[WebSocket ERROR: cannot parse Json message " + jsonMessage);
            return;
        }

        // Operation defined in message
        CommunicatorWebSocketMessageOperation operation;
        operation = wbMessage.getOperation();

        // Process message based on operation
        String property = wbMessage.getProperty();
        if (null != operation && null != property && !"".equals(property)) {
            switch (operation) {
                case REGISTERPROPERTY:
                    // Register property if not registered yet
                    if (propertySessions.get(property) == null) {
                        propertySessions.put(property, new ArrayList<Session>());
                    }
                    break;
            }
        }
    }

   /* private void sendMessage(GuiDTO guiDTO, String property) {
        Session session = sessions.get(guiDTO.getPlayerNr());
        CommunicatorMessage message = new CommunicatorMessage();
        message.setProperty(property);
        message.setContent(gson.toJson(guiDTO));
        try {
            session.getBasicRemote().sendText(gson.toJson(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
}
