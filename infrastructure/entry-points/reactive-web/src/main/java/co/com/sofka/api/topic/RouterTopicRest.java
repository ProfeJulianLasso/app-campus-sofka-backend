package co.com.sofka.api.topic;

import co.com.sofka.api.topic.handler.CreateTopicHandler;
import co.com.sofka.api.topic.handler.GetTopicHandler;
import co.com.sofka.api.topic.handler.ListTopicForLevelHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterTopicRest {
@Bean
public RouterFunction<ServerResponse> routerListTopicFunction(ListTopicForLevelHandler listTopicForLevelHandler) {
    return route(GET("/api/levels/{idlevel}"), listTopicForLevelHandler::GetListTopicForLevelHandler);
    }
}
