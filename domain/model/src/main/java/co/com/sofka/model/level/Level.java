package co.com.sofka.model.level;
import co.com.sofka.model.question.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Level {
    private String id = UUID.randomUUID().toString().substring(0, 36);
    private Set<String> topics;
    private String badge;
}
