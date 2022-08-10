package co.com.sofka.usecase.createinitialcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.usecase.createcourse.CreateCourseUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CreateInitialCourseUseCase implements BiFunction<InitialCourse, Course, Mono<InitialCourse>> {
    private final CourseRepository courseRepository;
    private final CreateCourseUseCase createCourseUseCase;
    @Override
    public Mono<InitialCourse> apply(InitialCourse initialCourse, Course course) {
        Set<String> questions = new HashSet<>();
        Flux.fromIterable( initialCourse.getQuestions())
                .map(question -> {
                    questions.add(question.getId());
                    return question.getId();
                }).collect(Collectors.toSet())
                .flatMap(ques -> {
                    course.setCourse(initialCourse.getCourse());
                    course.setCategory(initialCourse.getCategory());
                    course.setSubCategory(initialCourse.getSubCategory());
                    course.setQuestions(ques);
                    return createCourseUseCase.createCourse(course);
                }).subscribe();

        return Mono.just(initialCourse);
    }
}
