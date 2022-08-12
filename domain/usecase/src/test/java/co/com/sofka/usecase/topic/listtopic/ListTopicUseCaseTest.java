package co.com.sofka.usecase.topic.listtopic;

import co.com.sofka.model.question.Question;
import co.com.sofka.model.question.gateways.QuestionRepository;
import co.com.sofka.model.topic.Topic;
import co.com.sofka.model.topic.gateways.TopicRepository;
import co.com.sofka.usecase.question.listquestion.ListQuestionUseCase;
import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ListTopicUseCaseTest {

    TopicRepository topicRepository;
    ListTopicUseCase listTopicUseCase;

    @BeforeEach
    public void setup(){
        topicRepository = mock(TopicRepository.class);
        listTopicUseCase = new ListTopicUseCase(topicRepository);
    }

    @Test
    public void listarQuestion(){
        Set<String> previous = new HashSet<>();
        previous.add("id1");
        previous.add("id2");
        Set<String> previous1 = new HashSet<>();
        previous.add("id1");
        previous.add("id2");
        Set<String> previous2 = new HashSet<>();
        previous.add("id1");
        previous.add("id2");
        Topic topic1 = new Topic("1","name1","icon",previous);
        Topic topic2 = new Topic("2","name2","icon",previous1);
        Topic topic3 = new Topic("3","name3","icon",previous2);

        Flux<Topic> topics = Flux.just(topic1,topic2,topic3);

        StepVerifier.create(listTopicUseCase.listTopic("1"))
                .expectNextMatches(question1 -> {
                    assert question1.getId().equals("1");

                    return true;
                })
                .expectComplete();
        verify(topicRepository).findById("1");
    }

}