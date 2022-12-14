package co.com.sofka.usecase.user.createuser;

import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public Mono<User> createUser(User user) {
        return  userRepository.save(user);
    }
}
