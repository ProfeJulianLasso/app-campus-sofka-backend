package co.com.sofka.model.calendar.gateways;

import co.com.sofka.model.calendar.Calendar;
import reactor.core.publisher.Flux;

public interface CalendarRepository {

    Flux<Calendar> findAll();
}
