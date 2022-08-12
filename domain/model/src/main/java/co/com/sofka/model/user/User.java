package co.com.sofka.model.user;

import co.com.sofka.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

/**
 * [
 *  contiene el modelo de usuario
 *  con sus atributos adicional las anotacion
 *  para sus setter y getter
 *  contructores
 * ]
 * @version [1,0.0]
 *
 * @author [Yeferson Valencia, alejandro.yandd@gmail.com]
 * @since [1,0,0]
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {

        private String id = UUID.randomUUID().toString().substring(0, 36);
        private String email;
        private Set<Course> courses;

}
