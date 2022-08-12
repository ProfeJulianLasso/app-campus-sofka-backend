package co.com.sofka.model.flaglevel;
import co.com.sofka.model.topic.Topic;
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
public class FlagLevel {
    private String id = UUID.randomUUID().toString().substring(0, 36);
    private Set<Topic> topics;
    private String badge;
}
