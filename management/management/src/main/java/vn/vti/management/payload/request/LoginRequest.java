package vn.vti.management.payload.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginRequest {
    @NotNull
    private String username;

    @NotNull
    private String password;
}