package co.com.sofka.usecase.liststepfortopic;

import co.com.sofka.model.stepfortopic.StepForTopic;
import co.com.sofka.model.stepfortopic.gateways.StepForTopicRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public class ListStepForTopicUseCase implements BiFunction<String, String, Flux<StepForTopic>> {
    private final StepForTopicRepository stepForTopicRepository;

    @Override
    public Flux<StepForTopic> apply(String idStep, String idTopic) {
        Flux<StepForTopic> stepp = stepForTopicRepository.findAll();
        return stepp
                .filter(stepForTopic -> Objects.equals(stepForTopic.getIdTopic(), idTopic))
                    .filter(stepForTopic -> Objects.equals(stepForTopic.getIdStep(), idStep));
    }
}