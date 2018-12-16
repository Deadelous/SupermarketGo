package Rest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class RestServer {
      public void startRestServer() {
          System.out.println(RestStart.class.getCanonicalName());
          //System.setProperty("org.eclipse.jetty.LEVEL", "OFF");
          System.setProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.StdErrLog");
          System.setProperty("org.eclipse.jetty.LEVEL", "OFF");

          ServletContextHandler context = new
                  ServletContextHandler(ServletContextHandler.SESSIONS);
          context.setContextPath("/");

          Server jettyServer = new Server(8090);

          jettyServer.setHandler(context);
          ServletHolder jerseyServlet =
                  context.addServlet(ServletContainer.class, "/*");
          jerseyServlet.setInitOrder(0);
          // Tells the Jersey Servlet which REST service/class to load.
          jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "Rest");
          try {
              jettyServer.start();
              System.out.println(jettyServer.getURI());
          } catch (Exception error) {
              System.out.println("Server threw an error: " + error);
              jettyServer.destroy();

          }
      }
}
