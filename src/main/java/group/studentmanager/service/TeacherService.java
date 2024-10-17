package group.studentmanager.service;


import group.studentmanager.dao.repository.TeacherRepository;
import group.studentmanager.maper.TeacherMapper;
import group.studentmanager.model.RequestTeacher;
import group.studentmanager.model.ResponseTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {


    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;


    public ResponseEntity<ResponseTeacher> addteacher(RequestTeacher requestTeacher) {
        var teacherEntity = teacherMapper.mapToEntity(requestTeacher);
         teacherRepository.save(teacherEntity);
         var response = teacherMapper.mapTOTeacherDto(teacherEntity);
         return ResponseEntity.status(201).body(response);
    }
}
