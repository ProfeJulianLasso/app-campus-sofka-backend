package co.com.sofka.mongo.topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Document(value = "topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDocument {
    @Id
    private String id;
    private Set<String> previous;
    private String name;
    private String icon;
}
