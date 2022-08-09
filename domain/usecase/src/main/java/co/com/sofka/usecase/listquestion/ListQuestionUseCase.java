package co.com.sofka.usecase.listquestion;

import co.com.sofka.model.question.Question;
import co.com.sofka.model.question.gateways.QuestionRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListQuestionUseCase {
    private final QuestionRepository questionRepository;

    public Mono<Question> listQuestionUseCase(String id){
        return questionRepository.findById(id);
    }
}
