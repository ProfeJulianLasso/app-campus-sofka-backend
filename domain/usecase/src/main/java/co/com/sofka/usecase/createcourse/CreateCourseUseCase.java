package co.com.sofka.usecase.createcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.model.question.Question;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CreateCourseUseCase implements BiFunction<InitialCourse,Course,Mono<InitialCourse>> {
     private final CourseRepository courseRepository;

//     public Mono<Course> createCourse(Course course){
//         return courseRepository.save(course);
//     }

    @Override
    public Mono<InitialCourse> apply(InitialCourse initialCourse, Course course) {
        Set<String> questions = new HashSet<>();
        Flux.fromIterable( initialCourse.getQuestions())
                .map(question -> {
                        questions.add(question.getId());
                    return question.getId();
                }).collect(Collectors.toSet()).flatMap(ques -> {
                    course.setQuestions(ques);
                    return courseRepository.save(course);
                });
        return Mono.just(initialCourse);
    }
}
