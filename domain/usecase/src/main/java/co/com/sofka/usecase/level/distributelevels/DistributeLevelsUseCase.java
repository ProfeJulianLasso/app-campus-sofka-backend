package co.com.sofka.usecase.level.distributelevels;

import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.model.level.Level;
import co.com.sofka.model.level.gateways.LevelRepository;
import co.com.sofka.model.topic.Topic;
import co.com.sofka.model.topic.gateways.TopicRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DistributeLevelsUseCase implements Function<InitialCourse,Mono<InitialCourse>>  {
    private final LevelRepository levelRepository;

    private final TopicRepository topicRepository;
    @Override
    public Mono<InitialCourse> apply(InitialCourse initialCourse) {
        List<Level> levels = new ArrayList<>();
        Flux.fromIterable(initialCourse.getLevels())
                .flatMap(level -> {
                    level.getTopics().stream().map(topic -> {
                        Mono<Topic> topicMono = topicRepository.save(topic);
                        topicMono.map(topic1->topic1.getId()).map(element-> {

                        } )
                    });
                    levels.add(level);
                    return levelRepository.save(level);
                }).collect(Collectors.toSet()).subscribe();
        initialCourse.setLevels(levels);

        return Mono.just(initialCourse);
        // return initialCourseRepository.save(initialCourse);
    }
}
