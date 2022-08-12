package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * [
 *  contiene el test de listar usuario por id
 *  nos permite probar en pleno flujo, listar usuario segun el id
 *  que se mande
 * ]
 * @version [1,0.0]
 *
 * @author [Yeferson Valencia, alejandro.yandd@gmail.com]
 * @since [1,0,0]
 *
 */
@ExtendWith(MockitoExtension.class)
class ListUserIdUseCaseTest {
    @InjectMocks
    private ListUserIdUseCase listUserUseCase;

    @Mock
    private UserRepository userRepositoryTest;

    @Test
    void listUserTestId(){

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
        when(userRepositoryTest.findById("yef")).thenReturn(Mono.just(user2));

        StepVerifier.create(listUserUseCase.listUserId("yef"))
                .assertNext(users -> Assertions.assertEquals("yef", users.getId()))
                .expectComplete();
                 verify(userRepositoryTest).findById("yef");

    }


}