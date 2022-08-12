package co.com.sofka.model.calendar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Calendar {

    private String id = UUID.randomUUID().toString().substring(0, 36);
    private String date;
    private String title;
    private String url;
}
