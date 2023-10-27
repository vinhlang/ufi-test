package vn.vti.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vti.management.entity.Registration;

import java.util.Optional;


public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Long countRegistrationByIdClass(Long idClass);

    Optional<Registration> findByIdClassAndAndIdStudent(Long idClass, Long idStudent);
}
