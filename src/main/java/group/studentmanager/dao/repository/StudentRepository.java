package group.studentmanager.dao.repository;

import group.studentmanager.dao.entity.StudentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Modifying
    @Query("select s.fullname from StudentEntity s where s.id=:studentid")
    String adinitap(Long studentid);


    @Query("select s from StudentEntity s where s.age=:age")
    Optional<StudentEntity> findStudentEntityByAge(Long age);

    @Query(value = "select s.name from student s where s.id=:studentid", nativeQuery = true)
    String findName(Long studentid);


    @Query("select s from StudentEntity s where s.age=:age")
    List<StudentEntity> findallstudentsbyage(Long age, Pageable pageable);


}