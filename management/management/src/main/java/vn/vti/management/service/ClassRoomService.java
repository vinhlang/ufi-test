package vn.vti.management.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.vti.management.repository.ClassroomRepository;
import vn.vti.management.entity.Classroom;
import vn.vti.management.payload.request.ClassRoomRequest;

import java.util.Optional;

@Service
public class ClassRoomService {
    @Autowired
    ClassroomRepository classRoomRepository;

    public Classroom addClassRoom(ClassRoomRequest classRoomRequest){
        Classroom classRoom = new Classroom();
        BeanUtils.copyProperties(classRoomRequest, classRoom);
        classRoom = classRoomRepository.save(classRoom);
        return classRoom;
    }

    public boolean checkExistByName(String name){
        Optional<Classroom> classRoom = classRoomRepository.findClassRoomByName(name);
        return classRoom.isPresent();
    }
}
