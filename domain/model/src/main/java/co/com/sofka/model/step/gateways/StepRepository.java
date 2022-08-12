package co.com.sofka.model.step.gateways;

import co.com.sofka.model.step.Step;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface StepRepository {
 Mono<Step> save(Step step);
 Flux<Step> findAll();
}
