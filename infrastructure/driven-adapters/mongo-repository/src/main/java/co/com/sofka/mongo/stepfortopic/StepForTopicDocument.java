package co.com.sofka.mongo.stepfortopic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Document(value = "stepfortopic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepForTopicDocument {
    @Id
    private String id;
    private String idTopic;
    private String idStep;
    private String content;
    private String title;
    private String type;
    private String send;
    private String qualified;
    private Set<String> answers;
}
