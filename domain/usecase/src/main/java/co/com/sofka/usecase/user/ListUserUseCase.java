package co.com.sofka.usecase.user;
import co.com.sofka.model.user.User;
import co.com.sofka.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
;
@RequiredArgsConstructor
public class ListUserUseCase {
    private final UserRepository userRepository;
    public Flux<User> listUserUseCase() {
        return userRepository.findAll();
    }
}
