package armeria.rest.example;

import com.google.gson.Gson;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.common.MediaTypeNames;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public void start() {
        final ServerBuilder sb = Server.builder();
        sb.http(8080);
        sb.annotatedService(new Object() {
            @Get("/")
            @Produces(MediaTypeNames.JSON_UTF_8)
            public HttpResponse root() {
                Map<String, Object> entity = new HashMap<>();
                entity.put("name", "armeria-rest-example");
                entity.put("message", "It works on my machine!");
                return HttpResponse.of(HttpStatus.OK, MediaType.JSON_UTF_8, "%s", new Gson().toJson(entity));
            }
        });
        Server server = sb.build();
        server.start().join();
        LOGGER.info("Ready. Server running at http://127.0.0.1:{}", server.activeLocalPort());
    }

    public static void main(String[] args) {
        new App().start();
    }
}
