package co.com.sofka.mongo.topic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.UUID;


@Document(value = "topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDocument {
    @Id
    private String id;
    private String name;
    private String icon;
    private Boolean activated;
    private Boolean completed;
    private Set<String> previous;
}
