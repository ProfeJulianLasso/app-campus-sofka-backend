package co.com.sofka.usecase.listtopic;

import co.com.sofka.model.topic.Topic;
import co.com.sofka.model.topic.gateways.TopicRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListTopicUseCase {
    private final TopicRepository topicRepository;
    public Mono<Topic> listTopic(String id){
        return topicRepository.findById(id);
    }
}
