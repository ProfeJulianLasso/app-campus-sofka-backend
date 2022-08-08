package co.com.sofka.model.course;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Course {
    private String id;
    private Set<String> levels;
    private String course;
    private String category;
    private String subCategory;
    private String trophy;
    private Boolean trophyActivated;
    private Integer completed;
    private String image;
}
