package vn.vti.management.payload.request;

import java.util.Date;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class StudentInfo {

	private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthday;

    private int sex;

    private int active;
    
    private float gpa;

    private int type;
}
