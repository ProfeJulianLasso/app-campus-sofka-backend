package co.com.sofka.model.initialcourse;
import co.com.sofka.model.flagstep.FlagStep;
import co.com.sofka.model.level.Level;
import co.com.sofka.model.question.Question;
import co.com.sofka.model.step.Step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class InitialCourse {
        private String id = UUID.randomUUID().toString().substring(0, 36);
        private Set<Question> questions;
        private String course;
        private String category;
        private String subCategory;
        private List<Object> steps;
        private List<Object> levels;
        //    private String trophy;
//    private Boolean trophyActivated;
        private Integer completed;
        private String image;
    }


