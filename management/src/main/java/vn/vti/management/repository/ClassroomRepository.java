package vn.vti.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.vti.management.dto.ClassroomDto;
import vn.vti.management.entity.Classroom;



@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

     Optional<Classroom> findClassRoomByName(String name);

     Optional<Classroom> findClassRoomById(Long id);

     @Query(value = "SELECT c.id as idClass,"
     		+ "c.name as nameClass," +
    		 "c.id_teacher as idTeacher," + 
             "t.first_name as firstNameTeacher," +
             "t.last_name as lastNameTeacher," +
             " From (SELECT * from classroom ) AS c INNER JOIN teacher as t ON c.id_teacher = t.id", nativeQuery = true)
     List<ClassroomDto> getReportClassRoom();
}
