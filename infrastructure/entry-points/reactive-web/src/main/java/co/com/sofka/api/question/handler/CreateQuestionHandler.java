package co.com.sofka.api.question.handler;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.question.Question;
import co.com.sofka.usecase.createcourse.CreateCourseUseCase;
import co.com.sofka.usecase.createquestion.CreateQuestionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateQuestionHandler {

    private final CreateQuestionUseCase createQuestionUseCase;
    public Mono<ServerResponse> createQuestionPOSTUseCase(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Question.class)
                .flatMap(question -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createQuestionUseCase.createQuestionUseCase(question),Question.class));
    }

}
