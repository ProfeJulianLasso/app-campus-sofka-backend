package co.com.sofka.model.topic.gateways;

import co.com.sofka.model.topic.Topic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TopicRepository {
    Mono<Topic> save(Topic topic);

    Mono<Topic> findById(String id);

    Flux<Topic> findAll();
}
