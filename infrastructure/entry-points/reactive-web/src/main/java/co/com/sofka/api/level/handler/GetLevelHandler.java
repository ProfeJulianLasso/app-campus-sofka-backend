package co.com.sofka.api.level.handler;

import co.com.sofka.model.level.Level;
import co.com.sofka.model.question.Question;
import co.com.sofka.usecase.listlevels.ListLevelsUseCase;
import co.com.sofka.usecase.question.listquestion.ListQuestionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetLevelHandler {

    private final ListLevelsUseCase listLevelsUseCase;
    public Mono<ServerResponse> listLevelUseCase(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listLevelsUseCase.get(), Level.class);
    }



}
