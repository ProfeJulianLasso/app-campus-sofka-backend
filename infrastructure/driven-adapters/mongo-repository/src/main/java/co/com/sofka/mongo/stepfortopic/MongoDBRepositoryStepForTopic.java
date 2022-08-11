package co.com.sofka.mongo.stepfortopic;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryStepForTopic extends ReactiveMongoRepository<StepForTopicDocument, String>, ReactiveQueryByExampleExecutor<StepForTopicDocument> {
}
