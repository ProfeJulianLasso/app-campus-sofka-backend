package co.com.sofka.api.initialcourse;

import co.com.sofka.api.initialcourse.handler.CreateInitialCourseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterInitialCourseRest {
@Bean
public RouterFunction<ServerResponse> routerListInitialCoursesFunction(CreateInitialCourseHandler createInitialCourseHandler) {
    return route(POST("/api/courseinitial"), createInitialCourseHandler::createInitialCoursePOSTUseCase);
    }
}
