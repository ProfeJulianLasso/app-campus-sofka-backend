package co.com.sofka.mongo.user;

import co.com.sofka.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(value = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDocument {
    @Id
    private String id;
    private String email;
    private Set<Course> courses;
}
