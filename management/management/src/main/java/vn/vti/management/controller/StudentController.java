package vn.vti.management.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.vti.management.entity.Student;
import vn.vti.management.payload.request.StudentInfo;
import vn.vti.management.payload.response.Result;
import vn.vti.management.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/onboard")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<List<Result>> onboard(@Valid @RequestBody List<StudentInfo> studentOnboardRequest) {

        List<Result> response = new ArrayList<Result>();
        for (int i = 0; i < studentOnboardRequest.size(); i++) {
            Result result = new Result();
            result.setIndex(i);
            try {
                Long studentId = studentService.createOrUpdateStudent(studentOnboardRequest.get(i));
                result.setId(studentId);
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
    public ResponseEntity<List<Student>> getAll() {

        List<Student> response = studentService.getAllStudent();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
