package vn.vti.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import vn.vti.management.repository.StudentRepository;
import vn.vti.management.entity.Student;
import vn.vti.management.payload.request.StudentInfo;
import vn.vti.management.utils.EmailUtils;

import javax.validation.ValidationException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Transactional
	public Long createOrUpdateStudent(StudentInfo studentInfo) throws Exception{
		//check exist
		if(!EmailUtils.validate(studentInfo.getEmail())){
			throw new ValidationException("Invalid email format");
		}
		if(checkExsitByEmail(studentInfo)){
			throw new DuplicateKeyException("Email registed before!");
		}

		Student entity = new Student();
		BeanUtils.copyProperties(studentInfo, entity);
		entity = studentRepository.save(entity);
		
		return entity.getId();
	}

	private boolean checkExsitByEmail(StudentInfo studentInfo) {
		Optional<Student> student;
		if(studentInfo.getId() == null){
			student = studentRepository.findStudentByEmail(studentInfo.getEmail());
		} else{
			student = studentRepository.findStudentByIdAndEmail(studentInfo.getId(), studentInfo.getEmail());
		}

		return student.isPresent();
	}

	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
}
