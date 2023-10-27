package vn.vti.management.payload.response;

import lombok.Data;

@Data
public class Result {

	private Long id;
	
	private String status;
	
	private String message;

	private int index;
	
}
