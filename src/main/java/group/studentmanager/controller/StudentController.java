package group.studentmanager.controller;

import group.studentmanager.model.RequestStudent;
import group.studentmanager.model.ResponseStudent;
import group.studentmanager.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<ResponseStudent> post(@RequestBody @Valid RequestStudent requestStudent) {
        var responsestudent = studentService.addstudent(requestStudent);
        return ResponseEntity.status(200).body(responsestudent);
    }


    @GetMapping
    public List<ResponseStudent> getallstudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentid}")
    public ResponseStudent getStudent(@PathVariable Long studentid) {
        return studentService.getStudent(studentid);
    }




    @PutMapping("/{studentid}")
    public ResponseEntity<ResponseStudent> put( @RequestBody RequestStudent requestStudent,@PathVariable Long studentid) {
        ResponseStudent updatedStudent = studentService.updateStudent(requestStudent,studentid);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{studentid}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentid) {
        studentService.deleteStudent(studentid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
