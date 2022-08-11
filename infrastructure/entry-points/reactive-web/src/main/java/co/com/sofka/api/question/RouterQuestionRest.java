package co.com.sofka.api.question;

import co.com.sofka.api.question.handler.CreateQuestionHandler;
import co.com.sofka.api.question.handler.GetQuestionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterQuestionRest {
@Bean
public RouterFunction<ServerResponse> routerQuestionFunction(GetQuestionHandler getQuestionHandler, CreateQuestionHandler createQuestionHandler) {
    return route(GET("/api/question/{id}"), getQuestionHandler::listQuestionUseCase).andRoute
            (POST("/api/question"), createQuestionHandler::createQuestionPOSTUseCase);
    }
}
