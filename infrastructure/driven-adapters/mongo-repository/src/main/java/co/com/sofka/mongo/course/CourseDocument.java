package co.com.sofka.mongo.course;

import co.com.sofka.model.question.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.UUID;


@Document(value = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDocument {
    @Id
    private String id;
    private Set<String> questions;
    private String course;
    private String category;
    private String subCategory;
//    private String trophy;
//    private Boolean trophyActivated;
    private Integer completed;
    private String image;
}
