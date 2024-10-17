package group.studentmanager.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTeacher {

    private String name;
    private String surname;
    private Long salary;
    private String subject;

}
