package vn.vti.management.controller;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.management.entity.Classroom;
import vn.vti.management.payload.request.ClassRoomRequest;
import vn.vti.management.service.ClassRoomService;

import javax.validation.Valid;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;

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
    public ResponseEntity<String> getReportClassroom() {


        return new ResponseEntity<String>("{}", HttpStatus.OK);

    }
}
