package vn.vti.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.vti.management.entity.Teacher;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findTeacherByEmail(String email);

    @Query(value = "select * from Teacher where id != :id and email = :email" , nativeQuery = true)
    Optional<Teacher> findTeacherByIdAndEmail(@Param("id") Long id, @Param("email")String email);
}
