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
import static org.mockito.Mockito.when;

/**
 * [
 *  contiene el test de listar usuario
 *  nos permite probar en pleno flujo, si nos lista usuarios
 * ]
 * @version [1,0.0]
 *
 * @author [Yeferson Valencia, alejandro.yandd@gmail.com]
 * @since [1,0,0]
 *
 */
@ExtendWith(MockitoExtension.class)
class ListUserUseCaseTest {
    @InjectMocks
    private ListUserUseCase createUserUseCaseTest;

    @Mock
    private UserRepository userRepositoryTest;

    /**
     * [
     *  se instancian 2 usuarios, adicional se crea una lista de usuarios
     *  para agregar los usuarios instanciados, despues pasamos al flujo reactivo para probar
     *  con el repository el metodo listar todos los usuarios
     * ]
     * @version [1,0.0]
     *
     * @author [Yeferson Valencia, alejandro.yandd@gmail.com]
     * @since [1,0,0]
     *
     */
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