package co.com.sofka.model.flagstep;
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
public class FlagStep {
    private String id = UUID.randomUUID().toString().substring(0, 36);
    private Set<String> position;

}
