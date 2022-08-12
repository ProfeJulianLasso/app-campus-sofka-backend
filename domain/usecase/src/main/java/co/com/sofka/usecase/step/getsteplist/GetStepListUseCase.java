package co.com.sofka.usecase.step.getsteplist;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.model.step.Step;
import co.com.sofka.model.step.gateways.StepRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class GetStepListUseCase implements Supplier<Flux<Step>> {

    private final StepRepository stepRepository;

    @Override
    public Flux<Step> get() {
        return stepRepository.findAll();
    }
}
