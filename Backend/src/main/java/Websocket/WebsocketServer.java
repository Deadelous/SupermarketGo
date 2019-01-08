package Websocket;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import javax.websocket.server.ServerContainer;

public class WebsocketServer {
    private static final int PORT = 8095;

    private Server server;
    /**
     * @param args the command line arguments
     */
    public void setup() {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8100);
        server.addConnector(connector);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);

        handler.addServlet(MessagingServlet.class, "/messaging");
    }
        public void start() throws Exception {
            server.start();
            server.dump(System.err);
            server.join();
        }

        public static void main(String args[]) throws Exception {
            WebsocketServer theServer = new WebsocketServer();
            theServer.setup();
            theServer.start();
        }

}
