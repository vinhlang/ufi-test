package vn.vti.management.controller;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.management.entity.Teacher;
import vn.vti.management.payload.request.TeacherInfo;
import vn.vti.management.payload.response.Result;
import vn.vti.management.service.TeacherService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/onboard")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<List<Result>> onboard(@Valid @RequestBody List<TeacherInfo> teacherOnboardRequest) {

        List<Result> response = new ArrayList<Result>();
        for (int i =0 ;i<teacherOnboardRequest.size();i++){
            Result result = new Result();
            result.setIndex(i);
            try {
                Long teacherId = teacherService.createOrUpdateTeacher(teacherOnboardRequest.get(i));
                result.setId(teacherId);
                result.setMessage("success");

            } catch (Exception e) {
                result.setStatus("error");
                result.setMessage(e.getMessage());
            }

            response.add(result);

        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<List<Teacher>> getAll() {

        List<Teacher> response = teacherService.getAllTeacher();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
