package co.com.sofka.usecase.listcourses;
import co.com.sofka.model.course.Course;
import co.com.sofka.model.course.gateways.CourseRepository;
import co.com.sofka.usecase.course.listcourses.ListCoursesUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.HashSet;
import java.util.Set;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

    class ListCoursesUseCaseTest {
        CourseRepository courseRepository;
        ListCoursesUseCase listCoursesUseCase;

        @BeforeEach
        public void setup(){
            courseRepository = mock(CourseRepository.class);
            listCoursesUseCase = new ListCoursesUseCase(courseRepository);
        }

        @Test
        public void listarQuestion(){
            Set<String> questions = new HashSet<>();
            questions.add("id1");
            questions.add("id2");
            Set<String> questions1 = new HashSet<>();
            questions1.add("id1");
            questions1.add("id2");
            Set<String> questions2 = new HashSet<>();
            questions2.add("id1");
            questions2.add("id2");
            Course course = new Course("1",questions,"icon","previous","3",2,"image");
            Course course1 = new Course("2",questions,"icon","previous","3",2,"image");
            Course course2 = new Course("3",questions,"icon","previous","3",2,"image");

            Flux<Course> courses = Flux.just(course,course1,course2);

            when(courseRepository.save(Mockito.any(Course.class))).thenReturn(
                    Mono.just(course), Mono.just(course1), Mono.just(course2));
            when(courseRepository.findAll()).thenReturn(courses);

            var list = listCoursesUseCase.listCourses();

            Assertions.assertEquals(list.count().block(),3);

        }
    }
