package co.com.sofka.mongo.step;

import co.com.sofka.model.step.Step;
import co.com.sofka.model.step.gateways.StepRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterStep extends AdapterOperations<Step, StepDocument, String, MongoDBRepositoryStep>
        implements StepRepository
{

    public MongoRepositoryAdapterStep(MongoDBRepositoryStep repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Step.class));
    }
}
