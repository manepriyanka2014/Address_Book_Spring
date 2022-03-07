package com.bridgelabz.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

	@NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}([\\s][A-Z]{1}[a-z]{2,})?$", message = "Minimum 3 Characters and First Letter Should be Capital")
	private String fullName;
	
	@NotNull(message = "address Should Not be Empty")
	private String address;
	
	 @NotNull(message = "City Should Not be Empty")
	 @Pattern(regexp = "^[A-Z a-z]+$", message = "City Name Contains Only Alphabets.")
	private String city;
	
	 @NotNull(message = "State Should Not be Empty")
	 @Pattern(regexp = "^[A-Z a-z]+$", message = "State Name Contains Only Alphabets.")
	private String state;
	
	@NotNull(message = "phoneNumber Should be 10 digits")
	private String phoneNumber;
	
	@NotNull(message = "Zip Should Not be Empty")
    @Pattern(regexp = "\\d{6}", message = "Zip Code Contains Only Six Digits.")
	private String zipCode;

}
