package co.com.sofka.model.calendar.gateways;

import co.com.sofka.model.calendar.Calendar;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CalendarRepository {

    Flux<Calendar> findAll();

    Mono<Calendar> save(Calendar calendar);
}
