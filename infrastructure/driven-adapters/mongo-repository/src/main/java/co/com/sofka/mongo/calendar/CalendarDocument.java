package co.com.sofka.mongo.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "calendar")
public class CalendarDocument {
    @Id
    private String id;
    private String date;
    private String title;
    private String url;
}
