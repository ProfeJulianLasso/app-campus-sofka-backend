package co.com.sofka.usecase.createcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class CreateCourseUseCase  {
     private final CourseRepository courseRepository;

     public Mono<Course> createCourse(Course course){
         return courseRepository.save(course);
     }


}
