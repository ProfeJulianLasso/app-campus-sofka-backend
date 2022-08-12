package co.com.sofka.mongo.calendar;

import co.com.sofka.model.calendar.Calendar;
import co.com.sofka.model.calendar.gateways.CalendarRepository;
import co.com.sofka.model.level.Level;
import co.com.sofka.model.level.gateways.LevelRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import co.com.sofka.mongo.level.LevelDocument;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapterCalendar extends AdapterOperations<Calendar, CalendarDocument, String, MongoDBRepositoryCalendar>
 implements CalendarRepository
{

    public MongoRepositoryAdapterCalendar(MongoDBRepositoryCalendar repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Calendar.class));
    }
}
