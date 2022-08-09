package co.com.sofka.mongo.question;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.model.question.Question;
import co.com.sofka.model.question.gateways.QuestionRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterQuestion extends AdapterOperations<Question, QuestionDocument, String, MongoDBRepositoryQuestion>
 implements QuestionRepository
{

    public MongoRepositoryAdapterQuestion(MongoDBRepositoryQuestion repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Question.class));
    }
}
