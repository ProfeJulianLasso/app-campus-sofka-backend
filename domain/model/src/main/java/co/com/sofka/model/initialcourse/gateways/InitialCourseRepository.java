package co.com.sofka.model.initialcourse.gateways;

import co.com.sofka.model.initialcourse.InitialCourse;
import reactor.core.publisher.Mono;

public interface InitialCourseRepository {
    Mono<InitialCourse> save(InitialCourse initialCourse);
}
