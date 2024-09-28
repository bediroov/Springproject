package group.studentmanager.dao.repository;

import group.studentmanager.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {




}
