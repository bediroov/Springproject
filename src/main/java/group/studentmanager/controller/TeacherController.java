package group.studentmanager.controller;
import group.studentmanager.model.RequestTeacher;
import group.studentmanager.model.ResponseTeacher;
import group.studentmanager.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    public ResponseEntity<ResponseTeacher> savestudent(@RequestBody @Valid RequestTeacher requestTeacher) {
        return teacherService.addteacher(requestTeacher);
    }


}
