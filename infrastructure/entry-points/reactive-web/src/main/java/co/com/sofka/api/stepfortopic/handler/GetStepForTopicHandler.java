package co.com.sofka.api.stepfortopic.handler;

import co.com.sofka.model.stepfortopic.StepForTopic;
import co.com.sofka.usecase.stepfortopic.liststepfortopic.ListStepForTopicUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetStepForTopicHandler {

    private final ListStepForTopicUseCase listStepForTopicUseCase;
    public Mono<ServerResponse> listStepForTopicUseCase(ServerRequest serverRequest){
        var idStep = serverRequest.pathVariable("idStep");
        var idTopic = serverRequest.pathVariable("idTopic");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listStepForTopicUseCase.apply(idStep,idTopic), StepForTopic.class);
    }

}
