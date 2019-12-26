import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class Main {
    public static void main(String[] args ) throws Exception {
        AllRequest allRequest = new AllRequest();
        ServletContextHandler contextHelper = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHelper.addServlet(new ServletHolder(allRequest),"/*");
        Server server = new Server(8080);
        server.setHandler(contextHelper);
        server.start();
        server.join();
    }

}
