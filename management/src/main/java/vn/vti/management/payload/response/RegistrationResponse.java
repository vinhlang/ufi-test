package vn.vti.management.payload.response;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class RegistrationResponse {

    private Long id;

    private Long idStudent;

    private String firstNameStudent;

    private String lastNameStudent;

    private String addressStudent;

    private String emailStudent;

    private int sexStudent;

    private int typeStudent;

    private Timestamp registTime;
}
