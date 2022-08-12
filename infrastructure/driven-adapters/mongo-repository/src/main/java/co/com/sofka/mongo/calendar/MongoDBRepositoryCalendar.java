package co.com.sofka.mongo.calendar;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryCalendar extends ReactiveMongoRepository<CalendarDocument, String>, ReactiveQueryByExampleExecutor<CalendarDocument> {
}
