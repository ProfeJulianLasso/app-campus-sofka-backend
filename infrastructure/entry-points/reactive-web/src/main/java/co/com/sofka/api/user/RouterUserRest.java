package co.com.sofka.api.user;

import co.com.sofka.api.user.handler.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class RouterUserRest {
    @Bean
    public RouterFunction<ServerResponse> routerListUserFunction(Handler handler) {
        return route(GET("/api/user"), handler::listUserGetUseCase);
    }
}
