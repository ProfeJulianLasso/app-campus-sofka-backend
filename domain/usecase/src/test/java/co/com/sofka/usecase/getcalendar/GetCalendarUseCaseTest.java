package co.com.sofka.usecase.getcalendar;

import co.com.sofka.model.calendar.Calendar;
import co.com.sofka.model.calendar.gateways.CalendarRepository;
import co.com.sofka.model.course.Course;
import co.com.sofka.usecase.calendar.getcalendar.GetCalendarUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

class GetCalendarUseCaseTest {
    @SpyBean
    GetCalendarUseCase getCalendarUseCase;
    @MockBean
    CalendarRepository calendarRepository;
    @BeforeEach
    public void setup(){
        calendarRepository= mock(CalendarRepository.class);
        getCalendarUseCase=new GetCalendarUseCase(calendarRepository);
    }
    @Test
    void getCalendarTest(){

        Calendar calendar = new Calendar("1","2022-08-11","title","url");
        Calendar calendar1 = new Calendar("1","2022-08-11","title","url");
        Calendar calendar2 = new Calendar("1","2022-08-11","title","url");

        Flux<Calendar> calendars = Flux.just(calendar,calendar1,calendar2);

        Mockito.when(calendarRepository.findAll()).thenReturn(calendars);


        StepVerifier.create(calendarRepository.findAll().collectList())
                .assertNext(calendars1 -> Assertions.assertEquals(3, calendars1.size()))
                .expectComplete()
                .verify();
    }

}