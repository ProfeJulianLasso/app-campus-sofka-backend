package co.com.sofka.api.course;

import co.com.sofka.api.course.handler.CreateCourseHandler;
import co.com.sofka.api.course.handler.GetCoursesHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterCourseRest {
@Bean
public RouterFunction<ServerResponse> routerListCoursesFunction(GetCoursesHandler getCoursesHandler,CreateCourseHandler createCourseHandler) {
    return route(GET("/api/courses"), getCoursesHandler::listCoursesUseCase).andRoute
            (POST("/api/course"), createCourseHandler::createCoursePOSTUseCase);
    }
}
