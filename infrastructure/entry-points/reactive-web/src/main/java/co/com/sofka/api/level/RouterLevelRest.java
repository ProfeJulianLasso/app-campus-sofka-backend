package co.com.sofka.api.level;

import co.com.sofka.api.level.handler.GetLevelHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterLevelRest {
@Bean
public RouterFunction<ServerResponse> routerLevelFunction(GetLevelHandler getLevelHandler) {
    return route(GET("/api/levels"), getLevelHandler::listLevelUseCase);
    }
}
