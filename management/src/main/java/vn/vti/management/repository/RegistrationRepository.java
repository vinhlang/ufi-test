package vn.vti.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.vti.management.dto.RegistrationDto;
import vn.vti.management.entity.Registration;


import java.util.List;
import java.util.Optional;


public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Long countRegistrationByIdClass(Long idClass);

    Optional<Registration> findByIdClassAndAndIdStudent(Long idClass, Long idStudent);

    @Query(value = "SELECT r.id," +
    		"r.id_student as idStudent,"+
            "s.first_name as firstNameStudent," +
            "s.last_name as lastNameStudent," +
            "s.address as addressStudent," +
            "s.email as emailStudent," +
            "s.sex as sexStudent," +
            "s.type as typeStudent," +
            "r.regist_time as registTime" +
            " From (SELECT * from registration where id_class = :idClass ) AS r INNER JOIN student s ON r.id_student = s.id", nativeQuery = true)
    List<RegistrationDto> getReportRegistration(Long idClass);
}
