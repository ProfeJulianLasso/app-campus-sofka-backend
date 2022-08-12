package co.com.sofka.api.initialcourse.handler;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.usecase.course.createinitialcourse.CreateInitialCourseUseCase;
import co.com.sofka.usecase.step.createstep.CreateStepUseCase;
import co.com.sofka.usecase.level.distributelevels.DistributeLevelsUseCase;
import co.com.sofka.usecase.question.distributequestion.DistributeQuestionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateInitialCourseHandler {
    private final DistributeQuestionUseCase distributeQuestionUseCase;

    private final CreateStepUseCase createStepUseCase;
    private final DistributeLevelsUseCase distributeLevelsUseCase;

    private final CreateInitialCourseUseCase createInitialCourseUseCase;

    public Mono<ServerResponse> createInitialCoursePOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(InitialCourse.class)
                .flatMap(course -> distributeQuestionUseCase.apply(course))
                .zipWith(Mono.just(new Course()))
                .flatMap(element -> this.createInitialCourseUseCase.apply(element.getT1(),element.getT2()))
                .flatMap(element -> this.createStepUseCase.apply(element))
                .flatMap(element -> this.distributeLevelsUseCase.apply(element))
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(distributeQuestionUseCase.apply(element), InitialCourse.class));
    }



}
