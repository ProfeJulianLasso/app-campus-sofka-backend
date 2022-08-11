package co.com.sofka.mongo.step;

import co.com.sofka.mongo.question.QuestionDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryStep extends ReactiveMongoRepository<StepDocument, String>, ReactiveQueryByExampleExecutor<StepDocument> {
}
