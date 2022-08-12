package co.com.sofka.usecase.listquestion;

import co.com.sofka.model.question.Question;
import co.com.sofka.model.question.gateways.QuestionRepository;
import co.com.sofka.usecase.question.listquestion.ListQuestionUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

class ListQuestionUseCaseTest {

    QuestionRepository questionRepository;
    ListQuestionUseCase listQuestionUseCase;

    @BeforeEach
    public void setup(){
        questionRepository = mock(QuestionRepository.class);
        listQuestionUseCase = new ListQuestionUseCase(questionRepository);
    }

    @Test
    public void listarQuestion(){
        Set<String> answers = new HashSet<>();
        answers.add("respuesta1");
        answers.add("respuesta2");
        var question = new Question();
        question.setId("1");
        question.setQuestion("Vamos muchachos");
        question.setAnswers(answers);

        when(questionRepository.findById("1")).thenReturn(Mono.just(question));

        StepVerifier.create(listQuestionUseCase.listQuestionUseCase("1"))
                .expectNextMatches(question1 -> {
                    assert question1.getId().equals("1");
                    assert question1.getQuestion().equals("Vamos muchachos");
                    assert question1.getAnswers().contains(answers);
                    return true;
                })
                .expectComplete();
                verify(questionRepository).findById("1");
    }
}