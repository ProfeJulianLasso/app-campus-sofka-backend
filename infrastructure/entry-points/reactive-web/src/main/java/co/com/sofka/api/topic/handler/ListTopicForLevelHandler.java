package co.com.sofka.api.topic.handler;

import co.com.sofka.model.stepfortopic.StepForTopic;
import co.com.sofka.model.topic.Topic;
import co.com.sofka.usecase.listtopicforlevel.ListTopicForLevelUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
@Component
@RequiredArgsConstructor
public class ListTopicForLevelHandler {
    private final ListTopicForLevelUseCase listTopicForLevelUseCase;

    public Mono<ServerResponse> GetListTopicForLevelHandler(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("idlevel");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listTopicForLevelUseCase.apply(id), Topic.class);
    }
}