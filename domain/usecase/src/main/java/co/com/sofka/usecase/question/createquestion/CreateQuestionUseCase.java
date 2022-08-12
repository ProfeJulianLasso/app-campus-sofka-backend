package co.com.sofka.usecase.question.createquestion;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.model.question.Question;
import co.com.sofka.model.question.gateways.QuestionRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CreateQuestionUseCase  {
    private final QuestionRepository questionRepository;

    public Mono<Question> createQuestion (Question question){
        return questionRepository.save(question);
    }

}
