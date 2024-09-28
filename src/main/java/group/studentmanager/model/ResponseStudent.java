package group.studentmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// Get ucun
public class ResponseStudent {

    private Long id;
    private String name;
    private String surname;
    private Long age;
}
