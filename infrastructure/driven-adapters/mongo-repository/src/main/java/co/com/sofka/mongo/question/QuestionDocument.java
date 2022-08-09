package co.com.sofka.mongo.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Document(value = "question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDocument {
    @Id
    private String id;
    private String question;
    private Set<String> answers;
}
