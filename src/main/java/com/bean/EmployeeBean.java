package com.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class EmployeeBean {

	@Size(min = 3, max = 10, message = "Please check employeeName size")
	@NotBlank(message = "this field is required")
	private String employeeName;

	@NotNull(message = "age is required")
	private int eAge;
	private int eId;
	@Email(message = "pls check email")
	private String eEmail;

	@Pattern(regexp = "[a-z]*")
	@NotBlank(message = "this field is required")
	private String ePassword;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int geteAge() {
		return eAge;
	}

	public void seteAge(int eAge) {
		this.eAge = eAge;
	}

}
