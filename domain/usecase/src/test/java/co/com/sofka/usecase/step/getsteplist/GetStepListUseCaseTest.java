package co.com.sofka.usecase.step.getsteplist;

import co.com.sofka.model.step.Step;
import co.com.sofka.model.step.gateways.StepRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GetStepListUseCaseTest {

    StepRepository stepRepository;

    GetStepListUseCase getStepListUseCase;

    @BeforeEach
    public void setup(){
        stepRepository = mock(StepRepository.class);
        getStepListUseCase = new GetStepListUseCase(stepRepository);
    }

    @Test
    public void listarQuestion(){
        Set<String> questions = new HashSet<>();
        questions.add("id1");
        questions.add("id2");
        Set<String> questions1 = new HashSet<>();
        questions1.add("id1");
        questions1.add("id2");
        Set<String> questions2 = new HashSet<>();
        questions2.add("id1");
        questions2.add("id2");
        Step step = new Step("1",2,"image");
        Step step1 = new Step("2",2,"image");
        Step step2 = new Step("3",2,"image");

        Flux<Step> steps = Flux.just(step,step1,step2);

        when(stepRepository.save(Mockito.any(Step.class))).thenReturn(
                Mono.just(step), Mono.just(step1), Mono.just(step2));
        when(stepRepository.findAll()).thenReturn(steps);

        var list = getStepListUseCase.get();

        Assertions.assertEquals(list.count().block(),3);

    }
}