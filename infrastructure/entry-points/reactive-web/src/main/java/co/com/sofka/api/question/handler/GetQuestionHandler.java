package co.com.sofka.api.question.handler;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.question.Question;
import co.com.sofka.usecase.listcourses.ListCoursesUseCase;
import co.com.sofka.usecase.listquestion.ListQuestionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetQuestionHandler {

    private final ListQuestionUseCase listQuestionUseCase;
    public Mono<ServerResponse> listQuestionUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listQuestionUseCase.listQuestionUseCase(id), Question.class);
    }



}
