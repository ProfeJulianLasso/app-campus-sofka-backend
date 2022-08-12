package co.com.sofka.model.user;

import co.com.sofka.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

        private String id = UUID.randomUUID().toString().substring(0, 36);
        private String email;
        private Set<Course> courses;

}
