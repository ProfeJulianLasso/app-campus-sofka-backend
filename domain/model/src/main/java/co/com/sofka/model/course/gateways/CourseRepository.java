package co.com.sofka.model.course.gateways;

import co.com.sofka.model.course.Course;
import reactor.core.publisher.Flux;

public interface CourseRepository {
    Flux<Course> findAll();
}
