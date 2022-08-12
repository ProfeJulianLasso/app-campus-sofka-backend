package co.com.sofka.usecase.user;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * [
 *  contiene El caso de uso de usuario
 *  con sus metodos listar, guardar, listar por ID
 *  contructores
 * ]
 * @version [1,0.0]
 *
 * @author [Yeferson Valencia, alejandro.yandd@gmail.com]
 * @since [1,0,0]
 *
 */
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public Mono<User> createUser(User user) {
        return  userRepository.save(user);
    }
}
