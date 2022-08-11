package co.com.sofka.model.stepfortopic.gateways;

import co.com.sofka.model.stepfortopic.StepForTopic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StepForTopicRepository {
    Mono<StepForTopic> findById(String id);

    Flux<StepForTopic> findAll();
}
