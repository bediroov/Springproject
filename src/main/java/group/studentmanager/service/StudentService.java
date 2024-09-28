package group.studentmanager.service;

import group.studentmanager.dao.repository.StudentRepository;
import group.studentmanager.maper.StudentMapper;
import group.studentmanager.model.RequestStudent;
import group.studentmanager.model.ResponseStudent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }



    public ResponseStudent addstudent(RequestStudent requestStudent) {
        var studentEntity = studentMapper.mapToEntity(requestStudent);
        studentRepository.save(studentEntity);
        return studentMapper.mapToResponseDto(studentEntity);

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

        existingStudentEntity.setName(requestStudent.getName());
        existingStudentEntity.setSurname(requestStudent.getSurname());
        existingStudentEntity.setAge(requestStudent.getAge());

        studentRepository.save(existingStudentEntity);

        return studentMapper.mapToResponseDto(existingStudentEntity);

    }

}
