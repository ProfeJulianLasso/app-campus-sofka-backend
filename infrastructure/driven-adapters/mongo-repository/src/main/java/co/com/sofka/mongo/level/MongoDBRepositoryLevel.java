package co.com.sofka.mongo.level;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryLevel extends ReactiveMongoRepository<LevelDocument, String>, ReactiveQueryByExampleExecutor<LevelDocument> {
}
