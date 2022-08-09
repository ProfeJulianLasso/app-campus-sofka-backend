package co.com.sofka.mongo.topic;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryTopic extends ReactiveMongoRepository<TopicDocument, String>, ReactiveQueryByExampleExecutor<TopicDocument> {
}
