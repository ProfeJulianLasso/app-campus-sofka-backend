package co.com.sofka.mongo.user;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryUser extends ReactiveMongoRepository<UserDocument, String>, ReactiveQueryByExampleExecutor<UserDocument> {
}
