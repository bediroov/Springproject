package group.studentmanager.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class FakeStudentDto {

    private int id;
    private String name;
    private String company;
    private String username;
    private String email;
    private String address;
    private String zip;
    private String state;
    private String country;
    private String phone;
    private String photo;
}
