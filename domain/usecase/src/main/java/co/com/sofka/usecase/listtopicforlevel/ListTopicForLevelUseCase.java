package co.com.sofka.usecase.listtopicforlevel;

import co.com.sofka.model.level.Level;
import co.com.sofka.model.level.gateways.LevelRepository;
import co.com.sofka.model.topic.Topic;
import co.com.sofka.model.topic.gateways.TopicRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ListTopicForLevelUseCase implements Function<String, Flux<Topic>> {
    private final TopicRepository topicRepository;
    private final LevelRepository levelRepository;

    @Override
    public Flux<Topic> apply(String idLevel) {
        System.out.println(idLevel);
        Flux<Level> levelFlux = levelRepository.findAll();
        Set<String> idtopics = new HashSet<>();
        Set<Topic> topics = new HashSet<>();
        levelFlux.filter(level -> {
                            System.out.println(level.getId());
                            return Objects.equals(level.getId(), idLevel);
                        }
                )

                .map(level -> level.getTopics())
                .map(idtopic -> idtopics.addAll(idtopic)).subscribe(System.out::println);
        System.out.println(idtopics);
        idtopics.stream().map(id -> {
                    System.out.println(id);
                    return topicRepository.findById(id);
                }
        ).map((Mono<Topic> topicMono) -> {
            topicMono.map(topic -> topics.add(topic)).subscribe(System.out::println);
            return topicMono;
        });
        Flux<Topic> topicFlux = Flux.fromIterable(topics);
        return topicFlux;
    }
}
