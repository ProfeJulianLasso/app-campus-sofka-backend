package co.com.sofka.model.topic.gateways;

import co.com.sofka.model.topic.Topic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TopicRepository {
    Mono<Topic> save(Topic topic);
    Flux<Topic> findAll();
    Mono<Topic> findById(String id);
}
