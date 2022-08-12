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
public class ListTopicForLevelUseCase implements Function<String,Flux<Topic>> {
    private  final TopicRepository topicRepository;
    private final LevelRepository levelRepository;

    @Override
    public Flux<Topic> apply(String idLevel) {
        Flux<Level> levelFlux=levelRepository.findAll();
        Set<String> idtopics= new HashSet<>();
        Set<Topic> topics=new HashSet<>();
        levelFlux.filter(level -> Objects.equals(level.getId(),idLevel))
                .map(level -> level.getTopics())
                .map(idtopic->idtopics.addAll(idtopic));
       idtopics.stream().map(id->
            topicRepository.findById(id)
        ).map((Mono<Topic> topicMono) ->{
            topicMono.map(topic -> topics.add(topic));
            return  topicMono;
      });
        Flux<Topic> topicFlux=Flux.fromIterable(topics);
        return topicFlux;
    }
}
