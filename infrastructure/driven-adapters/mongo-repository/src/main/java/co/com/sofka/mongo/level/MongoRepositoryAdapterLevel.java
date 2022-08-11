package co.com.sofka.mongo.level;

import co.com.sofka.model.level.Level;
import co.com.sofka.model.level.gateways.LevelRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterLevel extends AdapterOperations<Level, LevelDocument, String, MongoDBRepositoryLevel>
 implements LevelRepository
{

    public MongoRepositoryAdapterLevel(MongoDBRepositoryLevel repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Level.class));
    }
}
