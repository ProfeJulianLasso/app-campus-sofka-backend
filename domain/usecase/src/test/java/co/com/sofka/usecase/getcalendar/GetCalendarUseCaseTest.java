package co.com.sofka.usecase.getcalendar;

import co.com.sofka.model.calendar.Calendar;
import co.com.sofka.model.calendar.gateways.CalendarRepository;
import co.com.sofka.usecase.calendar.getcalendar.GetCalendarUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
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
        //arrange
        String date="2022-08-11";
        Calendar calendar = new Calendar("1","2022-08-11","Preguntas","java.com");
        //Calendar calendar1 = new Calendar("2","2022-08-16","Preguntas1","java.com");
        // Calendar calendar2 = new Calendar("3","2022-08-18","Preguntas2","java.com");

        Mono<Calendar> calendarMono = Mono.just(calendar);
        //act
        when(calendarRepository.findAll()).thenReturn(calendarMono);
        //assert
        StepVerifier.create(getCalendarUseCase.apply(date)).expectNextMatches(calendars ->{
         assert calendars.getDate().equalsIgnoreCase(date);
            return true;
        }).verifyComplete();
        verify(calendarRepository).findAll();
    }

}