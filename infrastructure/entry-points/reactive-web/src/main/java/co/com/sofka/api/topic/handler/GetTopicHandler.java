package co.com.sofka.api.topic.handler;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.topic.Topic;
import co.com.sofka.usecase.listcourses.ListCoursesUseCase;
import co.com.sofka.usecase.listtopic.ListTopicUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetTopicHandler {

    private final ListTopicUseCase listTopicUseCase;
    public Mono<ServerResponse> listTopicUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listTopicUseCase.listTopic(id), Topic.class);
    }

}
