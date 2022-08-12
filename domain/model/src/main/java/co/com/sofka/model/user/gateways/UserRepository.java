package co.com.sofka.model.user.gateways;

import co.com.sofka.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * [
 *  contiene la intreface del repository usuario
 *  con sus metodos listar, guardar, listar por ID
 *  contructores
 * ]
 * @version [1,0.0]
 *
 * @author [Yeferson Valencia, alejandro.yandd@gmail.com]
 * @since [1,0,0]
 *
 */
public interface UserRepository {
    Flux<User> findAll();
    Mono<User> save(User user);
    Mono<User> findById(String id);
}
