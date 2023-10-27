package vn.vti.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vti.management.repository.ClassroomRepository;
import vn.vti.management.repository.RegistrationRepository;
import vn.vti.management.repository.StudentRepository;
import vn.vti.management.repository.TeacherRepository;
import vn.vti.management.entity.Classroom;
import vn.vti.management.entity.Registration;
import vn.vti.management.entity.Student;
import vn.vti.management.payload.request.RegistClassRequest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    public Registration registClass(RegistClassRequest registClassRequest) throws Exception {
            //check exsit classroom
        Optional<Classroom> classroom = classroomRepository.findClassRoomById(registClassRequest.getIdClass());
        if(!classroom.isPresent()){
            throw new Exception("Classroom is not found");
        }
        //check active user
        if(classroom.get().getActive() != 1){
            throw new Exception("Classroom is not active");
        }
        //check exist student
        Optional<Student> student = studentRepository.findStudentById(registClassRequest.getIdStudent());
        if(!student.isPresent()){
            throw new Exception("Student is not found");
        }
        //check active user
        if(student.get().getActive() != 1){
            throw new Exception("Student is not active");
        }
        //check regist before
        Optional<Registration> registration = registrationRepository.findByIdClassAndAndIdStudent(registClassRequest.getIdClass(), registClassRequest.getIdStudent());
        if(registration.isPresent()){
            throw new Exception("Student has registed before");
        }
        //check size classroom
        Long classSize = registrationRepository.countRegistrationByIdClass(classroom.get().getId());
        if(classSize >= 500){
            throw new Exception("Classroom has full");
        }
        Registration registrationEntity = new Registration();
        BeanUtils.copyProperties(registClassRequest, registrationEntity);
        registrationEntity.setRegistTime(new Timestamp((new Date()).getTime()));
        registrationEntity = registrationRepository.save(registrationEntity);

        return registrationEntity;
    }
}
