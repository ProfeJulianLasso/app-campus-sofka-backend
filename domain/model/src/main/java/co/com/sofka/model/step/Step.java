package co.com.sofka.model.step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Step {
    private String id = UUID.randomUUID().toString().substring(0, 36);
    private Integer position;
    private String name;
}
