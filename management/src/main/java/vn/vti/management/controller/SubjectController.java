package vn.vti.management.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import vn.vti.management.entity.Subject;
import vn.vti.management.payload.request.SubjectRequest;
import vn.vti.management.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
    SubjectService subjectService;


    @GetMapping("/getAll")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<List<Subject>> getAll() {

        List<Subject> response = subjectService.getAllSubject();

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    
    @PostMapping("/add")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<Subject> add(@RequestBody SubjectRequest subjectRequest
    		) throws Exception {

        Subject response = subjectService.addSubject(subjectRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
