package co.com.sofka.api.stepfortopic;


import co.com.sofka.api.stepfortopic.handler.CreateStepForTopicHandler;
import co.com.sofka.api.stepfortopic.handler.GetStepForTopicHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterStepForTopicRest {
@Bean
public RouterFunction<ServerResponse> routerListStepForTopicFunction(GetStepForTopicHandler getStepForTopicHandler, CreateStepForTopicHandler createStepForTopicHandler) {
    return route(GET("/api/stepfortopic/{idStep}/{idTopic}"), getStepForTopicHandler::listStepForTopicUseCase).andRoute
            (POST("/api/stepfortopic"), createStepForTopicHandler::createCreateStepForTopicPOSTUseCase);
    }
}
