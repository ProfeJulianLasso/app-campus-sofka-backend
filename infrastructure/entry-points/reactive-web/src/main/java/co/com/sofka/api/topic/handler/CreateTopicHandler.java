package co.com.sofka.api.topic.handler;

import co.com.sofka.model.topic.Topic;
import co.com.sofka.usecase.topic.createtopic.CreateTopicUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateTopicHandler {
    private final CreateTopicUseCase createTopicUseCase;

    public Mono<ServerResponse> createTopicPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Topic.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createTopicUseCase.createTopic(element), Topic.class));
    }
}
