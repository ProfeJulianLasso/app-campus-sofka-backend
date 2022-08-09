package co.com.sofka.model.course.gateways;

import co.com.sofka.model.course.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseRepository {
    Flux<Course> findAll();

    Mono<Course> save(Course course);
}
