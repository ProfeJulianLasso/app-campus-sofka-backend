package co.com.sofka.usecase.listlevels;

import co.com.sofka.model.level.Level;
import co.com.sofka.model.level.gateways.LevelRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class ListLevelsUseCase implements Supplier<Flux<Level>> {
    private final LevelRepository levelRepository;
    @Override
    public Flux<Level> get() {
        return levelRepository.findAll();
    }
}
