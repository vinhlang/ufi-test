package vn.vti.management.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.vti.management.entity.Student;

import java.util.Optional;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {
   
    Optional<Student> findStudentByEmail(String email);

    @Query(value = "select * from student where id != :id and email = :email" , nativeQuery = true)
    Optional<Student> findStudentByIdAndEmail(@Param("id") Long id, @Param("email")String email);

    Optional<Student> findStudentById(Long idStudent);
}
