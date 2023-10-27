package vn.vti.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.vti.management.repository.TeacherRepository;
import vn.vti.management.entity.Teacher;
import vn.vti.management.payload.request.TeacherInfo;
import vn.vti.management.utils.EmailUtils;

import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Transactional
    public Long createOrUpdateTeacher(TeacherInfo teacherInfo) throws Exception{
        //check exist
        if(!EmailUtils.validate(teacherInfo.getEmail())){
            throw new ValidationException("Invalid email format");
        }
        if(checkExsitByEmail(teacherInfo)){
            throw new DuplicateKeyException("Email registed before!");
        }

        Teacher entity = new Teacher();
        BeanUtils.copyProperties(teacherInfo, entity);
        entity = teacherRepository.save(entity);

        return entity.getId();
    }

    private boolean checkExsitByEmail(TeacherInfo teacherInfo) {
        Optional<Teacher> teacher;
        if(teacherInfo.getId() == null){
            teacher = teacherRepository.findTeacherByEmail(teacherInfo.getEmail());
        } else{
            teacher = teacherRepository.findTeacherByIdAndEmail(teacherInfo.getId(), teacherInfo.getEmail());
        }

        return teacher.isPresent();
    }

    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }
}
