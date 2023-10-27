package vn.vti.management.payload.request;

import lombok.Data;


import javax.validation.constraints.NotNull;

@Data
public class ClassRoomRequest {
    @NotNull
    private String name;

    @NotNull
    private Long idTeacher;

    @NotNull
    private Long idSubject;

}
