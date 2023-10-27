package vn.vti.management.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import vn.vti.management.dto.ClassroomDto;
import vn.vti.management.dto.RegistrationDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ClassResponse {

    private ClassroomDto classInfo;

    private List<RegistrationDto> registrationResponseList;
}
