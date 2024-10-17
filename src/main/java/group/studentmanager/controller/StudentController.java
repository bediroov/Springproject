package group.studentmanager.controller;

import group.studentmanager.dao.entity.StudentEntity;
import group.studentmanager.model.dto.FakeStudentDto;
import group.studentmanager.model.RequestStudent;
import group.studentmanager.model.ResponseStudent;
import group.studentmanager.model.dto.ProductDto;
import group.studentmanager.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<ResponseStudent> savestudent(@RequestBody @Valid RequestStudent requestStudent) {
        return studentService.addstudent(requestStudent);
    }

    @GetMapping
    public List<ResponseStudent> getallstudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentid}")
    public ResponseStudent getStudent(@PathVariable Long studentid) {
        return studentService.getStudent(studentid);
    }

    @GetMapping("/ad")
    public String getStudentnameById(@RequestParam("id") Long studentid) {
        return studentService.getStudentName(studentid);
    }

    @GetMapping("/list")
    public Optional<StudentEntity> getstudentlist(@RequestParam("age") Long age) {
        return studentService.getstudentlistbyage(age);
    }


    @PutMapping("/{studentid}")
    public ResponseEntity<ResponseStudent> put(@RequestBody RequestStudent requestStudent, @PathVariable Long studentid) {
        ResponseStudent updatedStudent = studentService.updateStudent(requestStudent, studentid);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{studentid}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentid) {
        studentService.deleteStudent(studentid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/fake")
    public List<FakeStudentDto> getStudentWithFeignClient(
    ) {
        return studentService.getFakeStudent();
    }



    @GetMapping("/fakeproduct")
    public List<ProductDto> getproductswithfeign(
    ) {
        return studentService.getfakeproducts();
    }


    @PostMapping("/fake")

    public ProductDto postproducts(@RequestBody ProductDto productDto){
        return studentService.postFakeProduct(productDto);
   }



    @GetMapping("/page")
    public List<ResponseStudent> getStudent
            (@RequestParam Integer pageNumber,
             @RequestParam Integer pageSize,
             @RequestParam Long age

            ) {

        return studentService.getStudentWithPagination(pageNumber, pageSize, age);
    }


}
