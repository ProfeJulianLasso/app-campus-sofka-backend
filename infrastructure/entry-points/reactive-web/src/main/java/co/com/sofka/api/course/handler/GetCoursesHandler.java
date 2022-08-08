package co.com.sofka.api.course.handler;

import co.com.sofka.model.course.Course;
import co.com.sofka.usecase.listcourses.ListCoursesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetCoursesHandler {
    private final ListCoursesUseCase listCoursesUseCase;
    public Mono<ServerResponse> listCoursesUseCase(ServerRequest serverRequest) {

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listCoursesUseCase.listCourses(), Course.class);
    }

}
