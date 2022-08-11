package co.com.sofka.model.user.gateways;

import co.com.sofka.model.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Flux<User> findAll();
    Mono<User> save(User user);
}
