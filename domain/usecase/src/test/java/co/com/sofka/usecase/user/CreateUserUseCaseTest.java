package co.com.sofka.usecase.user;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CreateUserUseCaseTest {
    @InjectMocks
    private CreateUserUseCase createUserUseCaseTest;

    @Mock
    private UserRepository userRepositoryTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createUserTest(){
        Course Set;
        User user = User.builder()
                .id("erf")
                .email("yefer@gmail.com")
                .build();

        when(userRepositoryTest.save(user)).thenReturn(Mono.just(user));

        StepVerifier.create(createUserUseCaseTest.createUser(user))
                .expectComplete()
                .verify();

    }
}