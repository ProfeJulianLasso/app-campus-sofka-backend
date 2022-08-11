package co.com.sofka.usecase.createinitialcourse;

import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.model.initialcourse.gateways.InitialCourseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListInitialCourseUseCase {
    private final InitialCourseRepository initialCourseRepository;

    public Flux<InitialCourse> listInitialCourse(){
        return initialCourseRepository.findAll();
    }
}
