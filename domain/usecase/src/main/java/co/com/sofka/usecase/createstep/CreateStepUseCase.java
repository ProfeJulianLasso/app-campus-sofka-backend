package co.com.sofka.usecase.createstep;



import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.model.step.Step;
import co.com.sofka.model.step.gateways.StepRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;


@RequiredArgsConstructor
public class CreateStepUseCase implements Function<InitialCourse,Mono<InitialCourse>> {
    private final StepRepository stepRepository;


    @Override
    public Mono<InitialCourse> apply(InitialCourse initialCourse) {
        JSONArray jsonarray = new JSONArray(initialCourse.getSteps());
        AtomicInteger index = new AtomicInteger();
        Flux.fromIterable(jsonarray)
                .flatMap(element -> {
                    Integer x = index.getAndIncrement();
                    JSONObject objeto = jsonarray.getJSONObject(x);
                    Set<String> stepss = jsonarray.getJSONObject(x).keySet();
                    String step = stepss.toString().replace("[","").replace("]","");
                    System.out.println(step);
                    Step stepSave = new Step();
                    return stepRepository.save(stepSave);
                }).subscribe();
        return Mono.just(initialCourse);
    }
}
