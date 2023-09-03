package javaAPI.test0;

import com.sun.net.httpserver.HttpServer;
import javaAPI.gitTest.JavaJjangPostHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class JavaServer {

    private Integer port = 5678;
    private HttpServer server = null;
    public JavaServer() throws IOException {

        server = HttpServer.create(new InetSocketAddress(port), 0);
        //server.createContext("/", new MyHandler());
        server.createContext("/", new MyHandler2());
        server.setExecutor(null);
        server.start();
        System.out.println("server started on port " + port);
    }
}
