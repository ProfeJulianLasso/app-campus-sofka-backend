package co.com.sofka.api.course.handler;

import co.com.sofka.model.course.Course;
import co.com.sofka.usecase.createcourse.CreateCourseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateCourseHandler {
    private final CreateCourseUseCase createCourseUseCase;

    public Mono<ServerResponse> createCoursePOSTUseCase(ServerRequest serverRequest) {
//        return serverRequest.bodyToMono(Course.class)
//                .flatMap(element -> ServerResponse.ok()
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(createCourseUseCase.apply(element), Course.class));
        return null;
    }
}
