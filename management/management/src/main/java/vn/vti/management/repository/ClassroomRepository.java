package vn.vti.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vti.management.entity.Classroom;

import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

     Optional<Classroom> findClassRoomByName(String name);

     Optional<Classroom> findClassRoomById(Long id);
}
