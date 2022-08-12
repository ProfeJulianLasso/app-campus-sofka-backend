package co.com.sofka.api.step;


import co.com.sofka.api.step.handler.GetStepHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterStepRest {
@Bean
public RouterFunction<ServerResponse> routerListStepFunction(GetStepHandler getStepHandler) {
    return route(GET("/api/steps"), getStepHandler::listStepUseCase);
    }
}
