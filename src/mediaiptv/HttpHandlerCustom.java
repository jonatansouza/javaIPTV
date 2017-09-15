/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaiptv;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author jonatan
 */
public class HttpHandlerCustom implements HttpHandler {
    private String rootDirectory;

    public HttpHandlerCustom(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        URI uri = httpExchange.getRequestURI();
        File file = new File(rootDirectory + uri.getPath()).getCanonicalFile();

        Headers responseHeaders = httpExchange.getResponseHeaders();

        if (uri.toString().contains(".ts")) {
            responseHeaders.set("Content-Type", "video/MP2T");
        } else {
            responseHeaders.set("Content-Type", "application/vnd.apple.mpegurl");
        }

        if (file.exists()) {
            byte[] bytes = Files.readAllBytes(Paths.get(file.toURI()));
            httpExchange.sendResponseHeaders(200, 0);

            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(bytes);
            outputStream.close();
        }
    }
}

// Creates a server on localhost, port 7777, runs on background thread
// Note that Media does not recognize localhost, you'll have to use 127.0.0.1
//HttpServer httpServer = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 7777), 0);
//httpServer.createContext("/", new CustomHttpHandler("/dir/to/files/to/play"));
//httpServer.start();

/**/

// Note the 127.0.0.1 here, localhost will NOT work!
//Media myMedia = new Media("http://127.0.0.1:7777/something.m3u8")
