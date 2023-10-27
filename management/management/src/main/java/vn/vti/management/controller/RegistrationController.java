package vn.vti.management.controller;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vti.management.entity.Registration;
import vn.vti.management.payload.request.RegistClassRequest;
import vn.vti.management.service.RegistrationService;

import javax.validation.Valid;


@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/add")
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    public ResponseEntity<Registration> authenticateUser(@Valid @RequestBody RegistClassRequest registClassRequest) throws Exception {

       Registration response = registrationService.registClass(registClassRequest);

       return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
