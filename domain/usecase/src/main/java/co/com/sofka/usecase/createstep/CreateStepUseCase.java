package co.com.sofka.usecase.createstep;



import co.com.sofka.model.step.Step;
import co.com.sofka.model.step.gateways.StepRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;



@RequiredArgsConstructor
public class CreateStepUseCase  {
    private final StepRepository stepRepository;

    public Mono<Step> createStep (Step step){
      return stepRepository.save(step);
    }
}
