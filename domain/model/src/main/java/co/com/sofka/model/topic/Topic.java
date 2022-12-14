package co.com.sofka.model.topic;
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
public class Topic {
    private String id = UUID.randomUUID().toString().substring(0, 36);
    private String name;
    private String icon;
    private Boolean activated;
    private Boolean completed;
    private Set<String> previous;
}
