package group.studentmanager.maper;
import group.studentmanager.dao.entity.CardEntity;
import group.studentmanager.dao.entity.StudentEntity;
import group.studentmanager.model.dto.CardDto;
import group.studentmanager.model.RequestStudent;
import group.studentmanager.model.ResponseStudent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;


@Mapper(componentModel = "spring")

public abstract class StudentMapper {

    //Bu Response Studentucundur
    @Mapping(target = "score", source = "score", qualifiedByName = "scoretoletter")
    public abstract ResponseStudent mapToResponseDto(StudentEntity studentEntity);


    public abstract List<ResponseStudent> listToDto(List<StudentEntity> StudentPage);


    // RequestStudent üçün mapper
    @Mapping(target = "card", source = "card")
    public abstract StudentEntity mapToEntity(RequestStudent requestStudent);


    public abstract CardEntity mapToCardEntity(CardDto cardDto);

    @Named("scoretoletter")

    public String maptoLetter(Long score) {
        if (score.equals(null)) {
            return null;
        } else if (score > 90) {
            return "A";
        } else if (score > 80) {
            return "B";
        } else if (score > 70) {
            return "C";
        } else if (score > 60) {
            return "D";
        } else if (score > 50) {
            return "E";
        } else {
            return "F";
        }
    }



}
