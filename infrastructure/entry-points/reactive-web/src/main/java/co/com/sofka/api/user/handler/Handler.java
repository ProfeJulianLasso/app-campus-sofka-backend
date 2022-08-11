package co.com.sofka.api.user.handler;

import co.com.sofka.model.user.User;
import co.com.sofka.usecase.user.ListUserUseCase;
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

    public Mono<ServerResponse> listUserGetUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listUserUseCase.listUser(), User.class);
    }
}
