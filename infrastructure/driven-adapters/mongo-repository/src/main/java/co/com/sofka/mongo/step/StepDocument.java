package co.com.sofka.mongo.step;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "step")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StepDocument {
    @Id
    private String id;
    private Integer position;
    private String name;
}
