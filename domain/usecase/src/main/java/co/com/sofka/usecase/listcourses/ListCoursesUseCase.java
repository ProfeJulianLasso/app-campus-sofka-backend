package co.com.sofka.usecase.listcourses;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Function;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class ListCoursesUseCase  {
    private final CourseRepository courseRepository;

    public Flux<Course> listCourses() {
        return courseRepository.findAll();
    }

}
