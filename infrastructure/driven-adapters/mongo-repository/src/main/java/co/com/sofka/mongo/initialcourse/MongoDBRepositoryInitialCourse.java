package co.com.sofka.mongo.initialcourse;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryInitialCourse extends ReactiveMongoRepository<InitialCourseDocument, String>, ReactiveQueryByExampleExecutor<InitialCourseDocument> {
}
