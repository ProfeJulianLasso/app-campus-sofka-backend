package co.com.sofka.usecase.createtopic;

import co.com.sofka.model.topic.Topic;
import co.com.sofka.model.topic.gateways.TopicRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListTopicUseCase {
    private final TopicRepository topicRepository;
    public Flux<Topic> listTopic(){
        return topicRepository.findAll();
    }
}
