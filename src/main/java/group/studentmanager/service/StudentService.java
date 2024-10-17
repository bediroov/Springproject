package group.studentmanager.service;
import group.studentmanager.client.ProductServiceClient;
import group.studentmanager.client.StudentServiceClient;
import group.studentmanager.dao.entity.StudentEntity;
import group.studentmanager.dao.repository.StudentRepository;
import group.studentmanager.model.dto.FakeStudentDto;
import group.studentmanager.model.RequestStudent;
import group.studentmanager.model.ResponseStudent;
import group.studentmanager.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import group.studentmanager.maper.StudentMapper;


@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private final StudentServiceClient studentServiceClient;
    private final ProductServiceClient productServiceClient;


//    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
//        this.studentRepository = studentRepository;
//        this.studentMapper = studentMapper;
//    }


    public ResponseEntity<ResponseStudent> addstudent(RequestStudent requestStudent) {
        var studentEntity = studentMapper.mapToEntity(requestStudent);
        studentRepository.save(studentEntity);
        var response = studentMapper.mapToResponseDto(studentEntity);
//        return studentMapper.mapToResponseDto(studentEntity);
        return ResponseEntity.status(200).body(response);

    }

    public List<ResponseStudent> getAllStudents() {
        var studentEntityList = studentRepository.findAll();
        return studentEntityList.stream()
                .map(studentMapper::mapToResponseDto).collect(Collectors.toList());
    }

    public ResponseStudent getStudent(Long studentid) {
        var studentEntity = studentRepository.findById(studentid)
                .orElseThrow(() -> new RuntimeException("not found student"));
        return studentMapper.mapToResponseDto(studentEntity);
    }


    public void deleteStudent(Long studentid) {
        studentRepository.deleteById(studentid);

    }

    public ResponseStudent updateStudent(RequestStudent requestStudent, Long studentid) {

        var existingStudentEntity = studentRepository.findById(studentid)
                .orElseThrow(() -> new RuntimeException("Tələbə tapılmadı"));

        existingStudentEntity.setFullname(requestStudent.getFullname());
        existingStudentEntity.setSurname(requestStudent.getSurname());
        existingStudentEntity.setAge(requestStudent.getAge());

        studentRepository.save(existingStudentEntity);

        return studentMapper.mapToResponseDto(existingStudentEntity);

    }


    public String getStudentName(Long studentid) {

        return studentRepository.adinitap(studentid);
//        return studentRepository.findName(studentid);
    }

    public Optional<StudentEntity> getstudentlistbyage(Long age) {

        return studentRepository.findStudentEntityByAge(age);
    }


    public List<ResponseStudent> getStudentWithPagination(Integer pageNumber, Integer pageSize, Long age) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "score"));
        List<StudentEntity> studentEntityList = studentRepository.findallstudentsbyage(age, pageable);
        return studentMapper.listToDto(studentEntityList);
    }


    public List<FakeStudentDto> getFakeStudent() {
        return studentServiceClient.getFakeStudent();

    }


    public ProductDto postFakeProduct(ProductDto productDto) {

        return productServiceClient.addProduct(productDto);
    }


    public List<ProductDto> getfakeproducts() {
        return productServiceClient.getallproducts();
    }
}
