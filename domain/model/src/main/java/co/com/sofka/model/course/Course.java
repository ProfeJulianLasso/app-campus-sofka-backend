package co.com.sofka.model.course;
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
public class Course {

    private String id = UUID.randomUUID().toString().substring(0, 36);
    private Set<String> questions;
    private String course;
    private String category;
    private String subCategory;
//    private String trophy;
//    private Boolean trophyActivated;
    private Integer completed;
    private String image;
}
