package group.studentmanager.maper;

import group.studentmanager.dao.entity.TeacherEntity;
import group.studentmanager.model.RequestTeacher;
import group.studentmanager.model.ResponseTeacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class TeacherMapper {


    //    @Mapping(target = "card", source = "card")
    public abstract TeacherEntity mapToEntity(RequestTeacher requestTeacher);


    public abstract ResponseTeacher mapTOTeacherDto(TeacherEntity teacherEntity);
}
