package co.com.sofka.usecase.createquestion;

import co.com.sofka.model.question.Question;
import co.com.sofka.model.question.gateways.QuestionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateQuestionUseCase {

    private final QuestionRepository questionRepository;

    public Mono<Question> createQuestionUseCase(Question question){
        return questionRepository.save(question);
    }
}
