package group.studentmanager.model;
import group.studentmanager.model.dto.CardDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

//RequestStudent (POST/PUT üçün)

public class RequestStudent {

    @NotBlank(message = "name cant empty")
    private String fullname;
    private String surname;
    private Long age;
    private CardDto card;
    private Long score;

}
