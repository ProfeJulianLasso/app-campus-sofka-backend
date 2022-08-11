package co.com.sofka.model.question;
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
public class Question {
    private String id = UUID.randomUUID().toString().substring(0, 36);
    private String question;
    private Set<String> answers;
}
