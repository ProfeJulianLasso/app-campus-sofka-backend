package co.com.sofka.api.calendar;

import co.com.sofka.api.calendar.handler.GetCalendarHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class RouterCalendarRest {
    @Bean
    public RouterFunction<ServerResponse> routerListCalendarFunction(GetCalendarHandler getCalendarHandler) {
        return route(GET("/api/calendar/{date}"), getCalendarHandler::getCalendar);
    }
}

