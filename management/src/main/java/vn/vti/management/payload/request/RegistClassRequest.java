package vn.vti.management.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegistClassRequest {

    @NotNull
    private Long idStudent;

    @NotNull
    private Long idClass;
}
