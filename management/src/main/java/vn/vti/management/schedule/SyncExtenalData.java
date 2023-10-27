package vn.vti.management.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import vn.vti.management.entity.Student;
import vn.vti.management.payload.request.StudentInfo;
import vn.vti.management.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Slf4j
@Component
public class SyncExtenalData {

    @Autowired
    StudentRepository studentRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void scheduleTaskWithCronExpression() {
        log.info("Sync data external student at 12a.m daily ");
        //assumess data external student from external api
        List<StudentInfo> data = new ArrayList<>();
        data.add(new StudentInfo(null, "firstname1", "lasetname1", "hanoi", "email1@gmail.com", new Date(), 1, 1, 8 ));
        data.add(new StudentInfo(null, "firstname2", "lasetname2", "hanoi", "email2@gmail.com", new Date(), 1, 1, 8 ));

        data.forEach(studentInfo -> {
            Student enity = new Student();
            //check data exist
            Optional<Student> student = studentRepository.findStudentByEmail(studentInfo.getEmail());
            if(student.isPresent()){
                studentInfo.setId(student.get().getId());
                enity = student.get();
            }
            enity.setType(2);
           //update new data
            BeanUtils.copyProperties(studentInfo, enity);
            studentRepository.save(enity);
        });


    }
}
