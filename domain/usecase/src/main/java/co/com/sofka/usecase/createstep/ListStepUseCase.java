package co.com.sofka.usecase.createstep;

import co.com.sofka.model.step.Step;
import co.com.sofka.model.step.gateways.StepRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListStepUseCase {
    private final StepRepository stepRepository;

    public Flux<Step> listStep(){
        return stepRepository.findAll();
    }
}
