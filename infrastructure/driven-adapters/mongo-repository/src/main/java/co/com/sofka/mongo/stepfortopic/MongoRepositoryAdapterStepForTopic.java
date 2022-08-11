package co.com.sofka.mongo.stepfortopic;

import co.com.sofka.model.stepfortopic.StepForTopic;
import co.com.sofka.model.stepfortopic.gateways.StepForTopicRepository;
import co.com.sofka.model.topic.Topic;
import co.com.sofka.model.topic.gateways.TopicRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterStepForTopic extends AdapterOperations<StepForTopic, StepForTopicDocument, String, MongoDBRepositoryStepForTopic>
 implements StepForTopicRepository
{

    public MongoRepositoryAdapterStepForTopic(MongoDBRepositoryStepForTopic repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, StepForTopic.class));
    }
}
