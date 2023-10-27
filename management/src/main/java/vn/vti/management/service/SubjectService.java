package vn.vti.management.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.vti.management.entity.Subject;
import vn.vti.management.payload.request.SubjectRequest;
import vn.vti.management.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	
	public List<Subject> getAllSubject(){
		return subjectRepository.findAll();
	}
	
	
	public Subject addSubject(SubjectRequest subjectRequest) throws Exception {
		
		//check exist
		List<Subject> subjects = subjectRepository.findByName(subjectRequest.getName());
		if(subjects != null && subjects.size() > 0) {
			throw new Exception("Duplicate subject name");
		}
		
		Subject entity = new Subject();
		BeanUtils.copyProperties(subjectRequest, entity);
		
		entity = subjectRepository.save(entity);
		
		return entity;
		
	}
}
