package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import co.com.sofka.usecase.user.createuser.CreateUserUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListUserUseCaseTest {
    @InjectMocks
    private CreateUserUseCase createUserUseCaseTest;

    @Mock
    private UserRepository userRepositoryTest;
    @Test
    void listUserTest(){

        User user1 = User.builder()
                .id("erf")
                .email("yefer@gmail.com")
                .build();

        User user2 = User.builder()
                .id("yef")
                .email("yef@gmail.com")
                .build();

        List<User> listUser = new ArrayList<>();
        listUser.add(user1);
        listUser.add(user2);

        when(userRepositoryTest.findAll()).thenReturn(Flux.fromStream(listUser.stream()));

        StepVerifier.create(userRepositoryTest.findAll().collectList())
                .assertNext(users -> Assertions.assertEquals(2, users.size()))
                .expectComplete()
                .verify();

    }

}