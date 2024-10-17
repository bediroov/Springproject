package group.studentmanager.dao.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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

    @Column(name = "name")
    private String fullname;
    private String surname;

    @Positive(message = "Age can to be less than zero")
    private Long age;

    private Long score;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private CardEntity card;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;



}
