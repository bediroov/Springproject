package group.studentmanager.dao.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Long age;


}
