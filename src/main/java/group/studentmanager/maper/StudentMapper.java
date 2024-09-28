package group.studentmanager.maper;

import group.studentmanager.dao.entity.StudentEntity;
import group.studentmanager.model.RequestStudent;
import group.studentmanager.model.ResponseStudent;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {


    //Bu Response Studentucundur
    public ResponseStudent mapToResponseDto(StudentEntity studentEntity) {
        ResponseStudent responseStudent = new ResponseStudent();

        responseStudent.setId(studentEntity.getId());
        responseStudent.setName(studentEntity.getName());
        responseStudent.setSurname(studentEntity.getSurname());
        responseStudent.setAge(studentEntity.getAge());
        return responseStudent;
    }

    // RequestStudent üçün mapper

    public StudentEntity mapToEntity(RequestStudent requestStudent) {

        StudentEntity studentEntity1 = new StudentEntity();
        studentEntity1.setName(requestStudent.getName());
        studentEntity1.setSurname(requestStudent.getSurname());
        studentEntity1.setAge(requestStudent.getAge());

        return studentEntity1;
    }
}
