package co.com.sofka.usecase.createtopic;

import co.com.sofka.model.topic.Topic;
import co.com.sofka.model.topic.gateways.TopicRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateTopicUseCase {

    private final TopicRepository topicRepository;

    public Mono<Topic> createTopic(Topic topic){
        return topicRepository.save(topic);
    }
}
