package co.com.sofka.usecase.liststepfortopic;

import co.com.sofka.model.stepfortopic.StepForTopic;
import co.com.sofka.model.stepfortopic.gateways.StepForTopicRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ListStepForTopicUseCase implements BiFunction<String, String, Flux<StepForTopic>> {
    private final StepForTopicRepository stepForTopicRepository;

    @Override
    public Flux<StepForTopic> apply(String idStep, String idTopic) {
        List<StepForTopic> list = new ArrayList<>();
        Flux<StepForTopic> stepp = stepForTopicRepository.findAll();
        System.out.println(stepp);
            stepp
                    .map(element -> {
                        list.add(element);
                        return element;
                    });
              //  .filter(stepForTopic -> Objects.equals(stepForTopic.getIdTopic(), idTopic))
                  //  .map(element -> list.add(new StepForTopic()))
                   // .filter(stepForTopic -> Objects.equals(stepForTopic.getIdStep(), idStep)).flatMap(element->)

        System.out.println(list);
        return stepp;

    }
}