package group.studentmanager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Get ucun
public class ResponseStudent {

    private Long id;
    private String fullname;
    private String surname;
    private Long age;
    private String score;
    private TeacherWithoutStudent teacher;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TeacherWithoutStudent{
        private Long id;
        private String name;
        private String surname;
        private Long salary;
        private String subject;
    }

}
