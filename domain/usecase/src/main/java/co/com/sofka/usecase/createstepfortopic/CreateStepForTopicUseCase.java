package co.com.sofka.usecase.createstepfortopic;

import co.com.sofka.model.stepfortopic.StepForTopic;
import co.com.sofka.model.stepfortopic.gateways.StepForTopicRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class CreateStepForTopicUseCase implements Function<StepForTopic, Mono<StepForTopic>> {
    private final StepForTopicRepository stepForTopicRepository;
    @Override
    public Mono<StepForTopic> apply(StepForTopic stepForTopic) {
        return stepForTopicRepository.save(stepForTopic);
    }
}
