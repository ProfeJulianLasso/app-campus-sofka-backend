package co.com.sofka.mongo.initialcourse;

import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.model.initialcourse.InitialCourse;
import co.com.sofka.model.initialcourse.gateways.InitialCourseRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterInitialCourse extends AdapterOperations<InitialCourse, InitialCourseDocument, String, MongoDBRepositoryInitialCourse>
 implements InitialCourseRepository
{

    public MongoRepositoryAdapterInitialCourse(MongoDBRepositoryInitialCourse repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, InitialCourse.class));
    }


}
