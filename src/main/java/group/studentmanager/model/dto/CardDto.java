package group.studentmanager.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class CardDto {
    private Long id;
    private String pan;
    private double balance;
    private LocalDateTime Expiredate;

}
