package co.com.sofka.usecase.createcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListCourseUseCase {
    private final CourseRepository courseRepository;

    public Flux<Course>lisCourse(){
        return courseRepository.findAll();
    }
}
