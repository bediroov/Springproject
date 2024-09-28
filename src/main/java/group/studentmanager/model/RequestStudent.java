package group.studentmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

//RequestStudent (POST/PUT üçün)

public class RequestStudent {

    @NotBlank(message = "name can not empty")
    private String name;

    private String surname;
    private Long age;
}
