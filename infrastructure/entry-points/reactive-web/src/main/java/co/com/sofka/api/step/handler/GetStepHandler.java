package co.com.sofka.api.step.handler;

import co.com.sofka.model.step.Step;
import co.com.sofka.usecase.step.getsteplist.GetStepListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetStepHandler {

    private final GetStepListUseCase getStepListUseCase;
    public Mono<ServerResponse> listStepUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getStepListUseCase.get(), Step.class);
    }

}
