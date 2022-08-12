package co.com.sofka.usecase.question.distributequestion;

import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.model.initialcourse.gateways.InitialCourseRepository;
import co.com.sofka.model.question.Question;
import co.com.sofka.model.question.gateways.QuestionRepository;
import co.com.sofka.usecase.question.createquestion.CreateQuestionUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DistributeQuestionUseCase implements Function<InitialCourse,Mono<InitialCourse>> {

    private final QuestionRepository questionRepository;
    private final CreateQuestionUseCase createQuestionUseCase;

    private final InitialCourseRepository initialCourseRepository;

    @Override
    public Mono<InitialCourse> apply(InitialCourse initialCourse) {
        Set<Question> questions = new HashSet<>();
        Flux.fromIterable(initialCourse.getQuestions())
                .flatMap(question -> {
                    questions.add(question);
                    return questionRepository.save(question);
                }).collect(Collectors.toSet()).subscribe();
        initialCourse.setQuestions(questions);

        return Mono.just(initialCourse);
    }

}
