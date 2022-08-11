package co.com.sofka.model.stepfortopic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StepForTopic {
    private String id = UUID.randomUUID().toString().substring(0, 36);
    private String idTopic;
    private String idStep;
    private String content;
    private String title;
    private String type;
    private String send;
    private String qualified;
    private Set<String> answers;
}
