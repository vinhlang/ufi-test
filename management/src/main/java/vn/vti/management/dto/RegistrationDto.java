package vn.vti.management.dto;

import java.sql.Timestamp;

public interface RegistrationDto {
	 Long getId();

     Long getIdStudent();

     String getFirstNameStudent();

     String getLastNameStudent();

     String getAddressStudent();

     String getEmailStudent();

     int getSexStudent();

     int getTypeStudent();

     Timestamp getRegistTime();

}
