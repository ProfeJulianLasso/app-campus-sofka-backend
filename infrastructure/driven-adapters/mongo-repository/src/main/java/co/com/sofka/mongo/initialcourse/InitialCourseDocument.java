package co.com.sofka.mongo.initialcourse;

import co.com.sofka.model.question.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Document(value = "initialcourse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InitialCourseDocument {
    @Id
    private String id;
    private Set<Question> questions;
    private String course;
    private String category;
    private String subCategory;
//    private String trophy;
//    private Boolean trophyActivated;
    private Integer completed;
    private String image;
}
