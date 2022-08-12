package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import co.com.sofka.usecase.user.createuser.CreateUserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {
    @InjectMocks
    private CreateUserUseCase createUserUseCaseTest;

    @Mock
    private UserRepository userRepositoryTest;

    @Test
    void createUserTest(){

        User user = User.builder()
                .id("erf")
                .email("yefer@gmail.com")
                .build();

        when(userRepositoryTest.save(Mockito.any(User.class))).thenReturn(Mono.just(user));

        StepVerifier.create(createUserUseCaseTest.createUser(user))
                .expectNext(user)
                .expectComplete()
                .verify();

    }
}