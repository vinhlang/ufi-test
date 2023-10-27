package vn.vti.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.vti.management.config.sercurity.jwt.JwtTokenProvider;
import vn.vti.management.entity.AccessInfo;
import vn.vti.management.payload.request.LoginRequest;
import vn.vti.management.payload.response.LoginResponse;
import vn.vti.management.service.AccessInfoService;

import javax.validation.Valid;


@RestController
public class AccessInfoController {

    @Autowired
    AccessInfoService accessInfoService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        AccessInfo accessInfo = accessInfoService.getAccessInfo(loginRequest.getUsername(), loginRequest.getPassword());
        String jwt = "";
        if(accessInfo != null) {
        	jwt = tokenProvider.generateToken(accessInfo.getId());

        	return new ResponseEntity<LoginResponse>(new LoginResponse(jwt), HttpStatus.OK);
        }

        return new ResponseEntity<LoginResponse>(new LoginResponse(jwt), HttpStatus.BAD_REQUEST);
        
        
    }
}
