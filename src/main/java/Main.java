import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MainServlet;
import servlets.MyServlet;


public class Main {


    public static void main(String[] args) throws Exception {
        MainServlet mainServlet = new MainServlet();
        MyServlet myServlet = new MyServlet();


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mainServlet), "/");

        ServletContextHandler context2 = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context2.addServlet(new ServletHolder(myServlet), "/mult");


        Server server = new Server(8080);
        server.setHandler(context);
        server.setHandler(context2);

        server.start();
        server.join();
    }
}
