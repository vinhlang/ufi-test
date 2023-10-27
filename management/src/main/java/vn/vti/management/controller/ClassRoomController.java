package vn.vti.management.controller;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.vti.management.dto.ClassroomDto;
import vn.vti.management.dto.RegistrationDto;
import vn.vti.management.entity.Classroom;
import vn.vti.management.payload.request.ClassRoomRequest;
import vn.vti.management.payload.response.ClassResponse;
import vn.vti.management.service.ClassRoomService;
import vn.vti.management.service.RegistrationService;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;
    
    @Autowired
    RegistrationService registrationService;

    @PostMapping("/add")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<Classroom> addClassroom(@Valid @RequestBody ClassRoomRequest classRoomRequest) {

        //check exsit
        if(classRoomService.checkExistByName(classRoomRequest.getName())){
            throw new DuplicateKeyException("Duplicate class name");
        }
        Classroom classRoom = classRoomService.addClassRoom(classRoomRequest);

        return new ResponseEntity<Classroom>(classRoom, HttpStatus.OK);

    }

    @GetMapping("/report")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<List<ClassResponse>> getReportClassroom() {

        List<ClassroomDto> classLst = classRoomService.getReportClassroom();
        List<ClassResponse> response = new ArrayList<ClassResponse>();
        classLst.forEach(classInfo -> {
        	List<RegistrationDto> lstRegistrationDtos = registrationService.getReportRegistration(classInfo.getIdClass());
        	ClassResponse classResponse = new ClassResponse(classInfo,lstRegistrationDtos);
        	response.add(classResponse);
        });
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
