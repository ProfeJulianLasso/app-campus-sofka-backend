package co.com.sofka.api.user.handler;

import co.com.sofka.model.user.User;
import co.com.sofka.usecase.user.createuser.CreateUserUseCase;
import co.com.sofka.usecase.user.listuser.ListUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final ListUserUseCase listUserUseCase;
    private final CreateUserUseCase createUserUseCase;

    public Mono<ServerResponse> listUserGetUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listUserUseCase.listUser(), User.class);
    }

    public Mono<ServerResponse> createUserPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(User.class)
                .flatMap(element -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createUserUseCase.createUser(element), User.class));
    }

}
