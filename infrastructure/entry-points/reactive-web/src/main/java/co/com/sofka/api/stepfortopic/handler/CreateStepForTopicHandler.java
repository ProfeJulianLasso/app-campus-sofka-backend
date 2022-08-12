package co.com.sofka.api.stepfortopic.handler;

import co.com.sofka.model.question.Question;
import co.com.sofka.model.stepfortopic.StepForTopic;
import co.com.sofka.usecase.createquestion.CreateQuestionUseCase;
import co.com.sofka.usecase.createstepfortopic.CreateStepForTopicUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateStepForTopicHandler {

    private final CreateStepForTopicUseCase createStepForTopicUseCase;
    public Mono<ServerResponse> createCreateStepForTopicPOSTUseCase(ServerRequest serverRequest){
        return serverRequest.bodyToMono(StepForTopic.class)
                .flatMap(stepForTopic -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createStepForTopicUseCase.apply(stepForTopic),StepForTopic.class));
    }

}
