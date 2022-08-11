package co.com.sofka.mongo.question;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryQuestion extends ReactiveMongoRepository<QuestionDocument, String>, ReactiveQueryByExampleExecutor<QuestionDocument> {
}
