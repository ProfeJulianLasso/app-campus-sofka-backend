package co.com.sofka.api.calendar.handler;

import co.com.sofka.model.calendar.Calendar;
import co.com.sofka.usecase.getcalendar.GetCalendarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetCalendarHandler {
    private final GetCalendarUseCase getCalendarUseCase;
    public Mono<ServerResponse> getCalendar(ServerRequest serverRequest){
        var date= serverRequest.pathVariable("date");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCalendarUseCase.apply(date),Calendar.class);
    }


}
