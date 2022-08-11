package co.com.sofka.model.question.gateways;

import co.com.sofka.model.question.Question;
import reactor.core.publisher.Mono;

public interface QuestionRepository {
    Mono<Question> save(Question question);
    Mono<Question> findById(String id);
}
