package co.com.sofka.usecase.getcalendar;

import co.com.sofka.model.calendar.Calendar;
import co.com.sofka.model.calendar.gateways.CalendarRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.function.Function;

@RequiredArgsConstructor
public class GetCalendarUseCase implements Function<String, Flux<Calendar>> {
    private final CalendarRepository calendarRepository;
    @Override
    public Flux<Calendar> apply(String date) {
       Flux<Calendar> calendarFlux= calendarRepository.findAll();
       calendarFlux.subscribe(System.out::println);
        return calendarFlux.filter(calendar->Objects.equals(calendar.getDate(),date));
    }
}
