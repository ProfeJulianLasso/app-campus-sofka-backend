package co.com.sofka.model.level.gateways;

import co.com.sofka.model.level.Level;
import reactor.core.publisher.Mono;

public interface LevelRepository {
    Mono<Level> save(Level level);
}
