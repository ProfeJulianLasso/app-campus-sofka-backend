package co.com.sofka.mongo.level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.UUID;


@Document(value = "level")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LevelDocument {
    @Id
    private String id;
    private Set<String> topics;
    private String badge;
}
